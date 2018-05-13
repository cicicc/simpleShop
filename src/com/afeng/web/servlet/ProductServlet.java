package com.afeng.web.servlet;

import com.afeng.domain.Product;
import com.afeng.service.ProductService;
import com.afeng.service.impl.ProductServiceImpl;
import com.afeng.web.base.BaseServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductServlet extends BaseServlet {
    private ProductService productService = new ProductServiceImpl();

    /**
     *根据分类id获取该分类下的所有商品,并将数据集合放入request域中
     * 名称categoryProductList
     */
    public void findByCid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数cid
        String cid = request.getParameter("cid");
        //调用service层 查询热门商品 并将热门商品以product的list集合形式保存起来
        List<Product> categoryProductList = productService.findByCid(cid);
        //将对象放入request域中
        request.setAttribute("categoryProductList",categoryProductList);
        //response.getWriter().write(categoryProductList.toString());
    }
    /**
     *查询热门商品,并将数据集合放入request域中
     * 名称hotProductList
     */
    public void findByHot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service层 查询热门商品 并将热门商品以product的list集合形式保存起来
        List<Product> hotProductList = productService.findByHot();
        //将对象放入request域中
        request.setAttribute("hotProductList",hotProductList);
    }
    /**
     *查询最新商品 并将数据集合放入request域中
     *名称newProductList
     */
    public void findByNew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service层 查询最新商品 并将最新商品以product的list集合形式保存起来
        List<Product> newProductList = productService.findByNew();
        //将对象放入request域中
        request.setAttribute("newProductList",newProductList);
    }
    /**
     *
     */
    public String findByPid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取页面传递过来的参数
        String pid = request.getParameter("pid");
        //调用service层 查询最新商品 并将最新商品以product的list集合形式保存起来
        Product product = productService.findByPid(pid);
        if (product != null) {
        //将对象放入request域中
        request.setAttribute("product",product);
        }
        return "product_info.jsp";
    }

}
