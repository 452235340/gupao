package com.gupao.vip.pattern.delegate.mvc;

import com.gupao.vip.pattern.delegate.mvc.controller.MemberController;
import com.gupao.vip.pattern.delegate.mvc.controller.OrderController;
import com.gupao.vip.pattern.delegate.mvc.controller.SystemController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by qingbowu on 2019/3/15.
 */
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatcher(req, resp);
    }

    private void doDispatcher(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uri = req.getRequestURI();
        String mid = req.getParameter("mid");

        if ("getMemberById".equals(mid)){
            new MemberController().getMemberById(mid);
        }else if ("getOrderById".equals(mid)){
            new OrderController().getOrderById(mid);
        }else if ("logout".equals(mid)){
            new SystemController().logout();
        }else {
            resp.getWriter().write("404 Not Found !!!");
        }
    }
}
