package com.afeng.web.servlet;

import com.afeng.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends BaseServlet {

    private static final long serialVersionUID = 3772632438542767334L;

    //    Setting->Inspections->Serialization issues->Serializable class without ’serialVersionUID’
    //反射方法必须为public
    public String testHello(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello servlet ");

        return "testJsp/hello.jsp";
    }
    public String testJrebel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello servlet ");

        return "testJsp/hello.jsp";
    }
}
