package com.afeng.web.filter;

import com.afeng.domain.User;
import com.afeng.service.UserService;
import com.afeng.service.impl.UserServiceImpl;
import com.afeng.utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    private UserService userService = new UserServiceImpl();
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //将传来的req和resp进行强转
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String servletPath = request.getServletPath();
        //从session域中获取loginUser信息  如果获取的到的话也就是登录了那么直接放行
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser != null) {
            chain.doFilter(request,response);
            return;//终止调用链
        }
        //如果是登录页面或者注册页面的话就直接放行
//        if (servletPath.startsWith("/login") || servletPath.startsWith("/register") || servletPath.startsWith("/index") || servletPath.startsWith("/userServlet")) {
//            //System.out.println("hello");
//            chain.doFilter(request,response);//放行
//            return;//终止调用链
//        }
        //查看cookie中有没有自动登录的cookie信息
        Cookie[] cookies = request.getCookies();
        String[] autoLogin = CookieUtils.getCookieByName(cookies, "autoLogin");
        User user = new User();
        //如果cookie中存在此登录对象 那么就获取此登录对象的信息 并且进行登录处理
        if (autoLogin != null && autoLogin.length > 1) {
            user.setUsername(autoLogin[0]);
            user.setPassword(autoLogin[1]);
            User login = userService.login(user);
            //将用户信息放入session域中
            request.getSession().setAttribute("loginUser",login);
            chain.doFilter(request,response);
        } else {
//            //如果没有此登录信息就将判断用户是否调用某个不可使用的jsp
//            if (servletPath.endsWith(".jsp") && !servletPath.startsWith("index") && !servletPath.startsWith("register")) {
//                response.sendRedirect(request.getContextPath() + "/login.jsp");
//            } else {
//                chain.doFilter(request,response);
//                return;
//            }
            //直接放行 再写下去脏代码太多了
            chain.doFilter(request,response);
                return;

        }
    }

    public void destroy() {
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
