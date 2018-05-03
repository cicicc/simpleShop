package com.afeng.web.servlet;

import com.afeng.service.UserService;
import com.afeng.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ActiveServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String activeCode = request.getParameter("activeCode");
        //创建service层对象 进行相应数据的查询 并根据获取的激活结果进行相对应的判断
        Integer activeRes = userService.active(activeCode);
        if (activeRes == 1) {
            response.sendRedirect(request.getContextPath() + "/activateSuccess.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/activateFailed.jsp");

        }

    }
}
