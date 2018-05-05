package com.afeng.web.servlet;

import com.afeng.domain.Category;
import com.afeng.service.CategoryService;
import com.afeng.service.impl.CategoryServiceImpl;
import com.afeng.web.base.BaseServlet;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoryServlet extends BaseServlet {
    private static final long serialVersionUID = 7497947445253374837L;
    private CategoryService categoryService = new CategoryServiceImpl();

    /**
     * 调用service层查询商品分类信息并返回给页面json数据
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取商品分类信息
        List<Category> list =categoryService.findAll();
        //将list集合转为json类型的对象并返回给页面
        Gson gson = new Gson();
        String json = gson.toJson(list);
        //System.out.println(json);
        response.getWriter().print(json);
    }
}
