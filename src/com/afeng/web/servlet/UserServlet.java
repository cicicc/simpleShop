package com.afeng.web.servlet;

import com.afeng.domain.User;
import com.afeng.service.UserService;
import com.afeng.service.impl.UserServiceImpl;
import com.afeng.utils.MailUtils;
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

    public String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //register
        //首先获取用户在页面上输入的注册信息
        Map<String, String[]> parameters = request.getParameterMap();
        User user = MyBeanUtils.populate(User.class, parameters);
        user.setUid(UUIDUtils.getUUID());
        user.setState(0);//是否被激活 0 未激活 1 激活
        user.setCode(UUIDUtils.getUUID64());//64位激活码
        //调用service层方法 执行注册
        //如果service层的方法返回的结果是1,表示注册成功 则调用邮件发送
        int registerRes = userService.register(user);
        //是否注册成功
        if (registerRes == 1) {
            //发送激活邮件
            String emailMsg = "恭喜您注册成功，请点击下面的连接进行激活账户"
                    + "<a href='http://localhost/active?activeCode=" + user.getCode() + "'>"
                    + "http://localhost/active?activeCode=" + user.getCode()  + "</a>";
            try {
                MailUtils.sendMail(user.getEmail(), emailMsg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //用户注册以后应该尝试跳转页面 提醒用户点击邮箱地址 实现注册
        return "adviceUserActivate.jsp";
    }

    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户输入的登录信息 包括用户名和登录密码
        Map<String, String[]> parameterMap = request.getParameterMap();
        //将数据封装带对象中去
        User user = MyBeanUtils.populate(User.class, parameterMap);
        //将用户信息传递到service层对象中 并且对返回值进行判断
        //如果用户输入的信息在数据库中有对应的user对象的话 那么就转到首页 否则就转到当前页面
        //注:转发到当前页面的时候记得如果将用户输入的用户名回写到输入框中
        User userRes =userService.login(user);
        if (userRes != null) {
            //查询到了用户信息的话就将用户信息放入session域中 表示用户已经登录 并将页面重定向到首页
            request.getSession().setAttribute("loginUser",userRes);
            response.sendRedirect(request.getContextPath()+"index.jsp");
            return null;
        }else{
            //若用户输入的个人信息无法在数据库中得到相匹配的结果的话 就转发到登录页面提示用户信息输入错误 并回写用户名
            request.setAttribute("msg","用户名或密码错误,请重新登陆");
            request.setAttribute("username",user.getUsername());
        }
        return "login.jsp";
    }
}
