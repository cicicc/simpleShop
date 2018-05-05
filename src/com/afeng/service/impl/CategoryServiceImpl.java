package com.afeng.service.impl;

import com.afeng.dao.CategoryDao;
import com.afeng.dao.impl.CategoryDaoImpl;
import com.afeng.domain.Category;
import com.afeng.service.CategoryService;

import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();

    /**
     *接收商品分类信息并处理相对应的异常
     * @return 商品分类信息
     */
    @Override
    public List<Category> findAll() {
        List<Category> categoryList = null;
        //调用dao层查询数据的方法 并处理异常
        try {
             categoryList = categoryDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;

    }
}
