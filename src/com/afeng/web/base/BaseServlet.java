package com.afeng.web.base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    private static final long serialVersionUID = -3802560024437785033L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //获取页面上的方法调用的参数 判断调用的是哪个方法
            String methodName = request.getParameter("method");
            //如果调用的是方法为空 那么就默认使用execute方法
            if (methodName == null) {
                methodName = "execute";
            }
            //根据当前methodName 判断需要执行的method方法是哪一个
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //执行这个方法 这个方法可能会返回一个jsp路径
            String jspPath = (String) method.invoke(this, request, response);
            //判断这个jsp路径是否为空 如果不为空的话 就将请求转发过去
            if (jspPath != null) {
                request.getRequestDispatcher(request.getContextPath()+"/"+jspPath).forward(request, response);
                return;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //创建一个Noop方法 留给子类重写这个方法
        return null;
    }
}
