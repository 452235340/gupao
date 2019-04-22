package com.wuqingbo.spring.framework.aop.support;

import com.wuqingbo.spring.framework.aop.config.QBAopConfig;

import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by qingbowu.
 */
public class QBAdvisedSupport {

    private Class<?> targetClazz;

    private Object targetObje;

    private QBAopConfig aopConfig;

    private Pattern poinCutClassPattern;

    public QBAdvisedSupport(QBAopConfig aopConfig) {
        this.aopConfig = aopConfig;
    }

    public Class<?> getTargetClass() {
        return this.targetClazz;
    }

    public Object getTarget() {
        return null;
    }

    public List<Object> getInterceptorsAndDynamicInterceptionAdvice(Method method, Object target) {
        return null;
    }



    public void setTargetClazz(Class<?> clazz) {
        this.targetClazz = clazz;
        parse();
    }

    private void parse() {
        String pointCut = this.aopConfig.getPointCut()
                .replaceAll("\\.","\\\\.")
                .replaceAll("\\\\.\\*",".*")
                .replaceAll("\\(","\\\\(")
                .replaceAll("\\)","\\\\)");

        //public .* com.wuqingbo.spring.demo.service..*Service..*(.*)
        String pointCutForClass = pointCut.substring(0, pointCut.lastIndexOf("\\(") - 4);
        poinCutClassPattern = Pattern.compile("class " + pointCutForClass.substring(pointCutForClass.lastIndexOf(" ")+1));
    }

    public Object getTargetObje() {
        return targetObje;
    }

    public void setTargetObje(Object targetObje) {
        this.targetObje = targetObje;
    }

    public boolean pointCutMatch() {
        return poinCutClassPattern.matcher(this.targetClazz.toString()).matches();
    }
}
