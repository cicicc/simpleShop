package com.afeng.service.impl;

import com.afeng.dao.ProductDao;
import com.afeng.dao.impl.ProductDaoImpl;
import com.afeng.domain.Product;
import com.afeng.service.ProductService;

import java.sql.SQLException;
import java.util.List;
//这个service层中所有方法都没有使用事务
public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new ProductDaoImpl();
    /**
     * 开启事务
     * 调用dao层 根据数据是否有热门标记获取商品
     * 并处理异常
     * @return 查询到的商品list
     */
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
    /**
     * 开启事务
     * 调用dao层 根据数据上架日期获取最新商品
     * 并处理异常
     * @return 查询到的商品list
     */
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

    /**
     * 调用dao层 通过对象所属的分类查询对应的商品
     * 并处理异常
     * @param cid Category的id
     * @return 查询到的商品list
     */
    @Override
    public List<Product> findByCid( String cid) {
        //调用dao层方法并捕获异常
        List<Product> productList = null;
        try {
            productList = productDao.findByCid(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
    /**
     * 调用dao层 通过对象所属的id查询到对应的商品
     * 并处理异常
     * @param pid 商品的id
     * @return 查询到的商品 null或者Product对象
     */
    @Override
    public Product findByPid(String pid) {
        Product product = null;
        try {
            product =productDao.findByPid(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

}
