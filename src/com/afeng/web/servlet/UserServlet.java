package com.afeng.web.servlet;

import com.afeng.domain.User;
import com.afeng.service.UserService;
import com.afeng.service.impl.UserServiceImpl;
import com.afeng.utils.MyBeanUtils;
import com.afeng.utils.UUIDUtils;
import com.afeng.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    public void checkUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置verifyRes 如果数据库中存在此用户名 那么就告知用户此用户名已经被占用 否则就可以让用户使用此用户名
        int verifyRes = -1;
        //获取用户输入的用户名参数
        String username = request.getParameter("username");
        //调用service层 得到对应的结果 并且对结果进行判断 如果为null 那么就是没有查询到，也就是无此用户名
        User existUser = userService.verifyUsername(username);
        if (existUser == null) {
            verifyRes = 1;
        }
        //System.out.println("verifyRes"+verifyRes); 此处不可以使用write
        response.getWriter().println(verifyRes);
    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //register
        //首先获取用户在页面上输入的注册信息
        Map<String, String[]> parameters = request.getParameterMap();
        User user = MyBeanUtils.populate(User.class, parameters);
        user.setUid(UUIDUtils.getUUID());
        userService.register(user);


    }


}
