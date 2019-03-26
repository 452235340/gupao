package com.gupao.vip.mvcframework.servlet;

import com.gupao.vip.mvcframework.annotation.MyAutowired;
import com.gupao.vip.mvcframework.annotation.MyController;
import com.gupao.vip.mvcframework.annotation.MyRequestmapping;
import com.gupao.vip.mvcframework.annotation.MyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * Created by qingbowu on 2019/3/25.
 */
public class MyDispatchServlet extends HttpServlet {

    private static final String LOCATION = "contextConfigLocation";

    private Properties properties = new Properties();

    private  List<String> className = new ArrayList<String>();

    private Map<String,Object> IOC = new HashMap<String,Object>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


    @Override
    public void init() throws ServletException {
        //1、加载配置文件
        this.loadConfig(LOCATION);

        //2、扫描所有相关的类
        scannerPackage(properties.getProperty("scanPackage"));

        //3、初始化所有相关类的实例，即初始化IOC容器
        doInstance();

        //4、将所有IOC容器中所有有依赖关系的类，实现依赖注入，即赋值
        doAutoWirted();

        //5、构造HandlerMapping
        initHandlerMapping();


        //6、等待请求、很久url拿到Handlermapping中对应的的方法，利用反射进行调用

        System.out.println("my spring framework is started");
    }

    /**
     * 初始化HandlerMapping，将MyController中的方法与url的对应关系注册到HandlerMapping中
     */
    private void initHandlerMapping() {
        if (IOC.isEmpty()){return;}
        for (Map.Entry<String,Object> entry : IOC.entrySet()){
            Class<?> clazz = entry.getValue().getClass();
            if (!clazz.isAnnotationPresent(MyController.class)){continue;}

            Method[] methods = entry.getValue().getClass().getMethods();
            for (Method method : methods){
                if (!method.isAnnotationPresent(MyRequestmapping.class)){continue;}

            }
        }
    }

    /**
     * 依赖注入
     */
    private void doAutoWirted() {
        if (IOC.isEmpty()){return;}
        for (Map.Entry<String,Object> entry : IOC.entrySet()){
            //拿到每个类所有的字段
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields){
                if (!field.isAnnotationPresent(MyAutowired.class)){continue;}
                MyAutowired myAutowired = field.getAnnotation(MyAutowired.class);
                   String beanName = myAutowired.value().trim();
                if ("".equals(beanName)){
                    beanName = field.getType().getName();
                }
                field.setAccessible(true);
                try {
                    field.set(entry.getValue(),IOC.get(beanName));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 实例活所有相关类
     */
    private void doInstance() {
        if (className.size()>0){
            try {
                for (String className : className){
                    Class<?> clazz = Class.forName(className);
                    if (clazz.isAnnotationPresent(MyController.class)){
                        String classname = lowerFirstCase(clazz.getSimpleName());
                        IOC.put(classname,clazz.newInstance());
                    }else if (clazz.isAnnotationPresent(MyService.class)){
                        MyService myService = clazz.getAnnotation(MyService.class);
                        String serviceName = myService.value();
                        //如果设置了名字，则使用用户自己设置的
                        if (!"".equals(serviceName)){
                            IOC.put(serviceName,clazz.newInstance());
                            continue;
                        }
                        //若未设置则按接口类型创建一个实例
                        Class<?>[] interfaces = clazz.getInterfaces();
                        for (Class<?> cls : interfaces){
                            IOC.put(cls.getName(),cls.newInstance());
                        }
                    }else {
                        continue;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 首字母小写
     * 利用ASCII码中大写字符与小写字符值相差32的规则实现首字母小写
     * @param simpleName
     * @return
     */
    private String lowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    /**
     * 扫描配置文件配置的路劲下所有的类
     * @param packageName
     */
    private void scannerPackage(String packageName) {
        //将所有的包路劲转换为文件路劲
        URL url = this.getClass().getClassLoader().getResource("/" + packageName.replaceAll("\\.","/"));
        File dir = new File(url.getPath());
        for(File file : dir.listFiles()){
            if (file.isDirectory()){
                //如果是文件则继续递归
                scannerPackage(packageName+file.getName());
            }
            className.add(packageName + "." + file.getName().replace(".clsss","").trim());
        }
    }

    /**
     * 根据web.xml配置参数获取配置文件名，然后加载该配置文件
     * @param location
     */
    private void loadConfig(String location) {
        InputStream fis = null;
        try {
            fis = this.getClass().getResourceAsStream(location);
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != fis){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
