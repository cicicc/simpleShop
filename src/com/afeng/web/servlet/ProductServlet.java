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
}
