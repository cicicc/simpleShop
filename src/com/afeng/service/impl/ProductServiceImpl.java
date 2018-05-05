package com.afeng.service.impl;

import com.afeng.dao.ProductDao;
import com.afeng.dao.impl.ProductDaoImpl;
import com.afeng.domain.Product;
import com.afeng.service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new ProductDaoImpl();

    @Override
    public List<Product> findByHot() {
        //调用dao层方法并捕获异常
        List<Product> productList = null;
        try {
            productList = productDao.findByHot();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> findByNew() {
        //调用dao层方法并捕获异常
        List<Product> productList = null;
        try {
            productList = productDao.findByNew();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
