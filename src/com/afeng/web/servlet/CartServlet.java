package com.afeng.web.servlet;

import com.afeng.domain.Cart;
import com.afeng.domain.Product;
import com.afeng.service.ProductService;
import com.afeng.service.impl.ProductServiceImpl;
import com.afeng.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CartServlet  extends BaseServlet {
    private ProductService productService = new ProductServiceImpl();
    /**
     * 添加商品到购物车中
     */
    public void add2Cart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数
        String pid = request.getParameter("pid");
         Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        //通过id查询到商品
        Product product = productService.findByPid(pid);
        //获取到session中的cart兑现
        Cart cart = getCart(request.getSession());
        cart.add2Cart(product,quantity);
        System.out.println(cart);
        //重定向到购物车中
        response.sendRedirect(request.getContextPath()+"/cart.jsp");
    }

    /**
     *获取session中的cart对象 如果session中没有的话 就新建一个
     * @param session 跟随请求传来的session对象
     * @return cart对象
     */
    public Cart getCart(HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
             cart = new Cart();
             session.setAttribute("cart",cart);
        }
        return cart;
    }
}
