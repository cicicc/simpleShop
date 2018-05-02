package com.afeng.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.首先将req和res强转为HTTPServlet形式 否则无法使用一些方法
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //2.设置编码 这一步在Tomcat8以后其实并没有太多的必要 因为在Tomcat8以前使用的是iso-8859进行的编码，而在之后的版本中是以UTF-8中进行编码的4
        //response的编码还是需要设置一下 因为在一些写过的程序中出现了一些页面乱码问题 由于未曾阅读源码 所以暂时不太理解问题原因 先进行解决
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //实现放行 由于无需对request进行编解码 所以在这里无需使用装饰者模式 对参数进行增强
        chain.doFilter(request,response);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
