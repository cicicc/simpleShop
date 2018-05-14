package com.afeng.service.impl;

import com.afeng.dao.ProductDao;
import com.afeng.dao.impl.ProductDaoImpl;
import com.afeng.domain.Product;
import com.afeng.service.ProductService;
import com.afeng.domain.PageBean;

import java.sql.SQLException;
import java.util.List;
//这个service层中所有方法都没有使用事务
public class ProductServiceImpl implements ProductService {
   private ProductDao productDao = new ProductDaoImpl();
    /**
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
     * @param pageNumber 当前页的页码数
     * @param pageSize 每页显示数据的数目
     * @return 查询到的商品list 封装为pageBean
     */
    @Override
    public PageBean<Product> findByCid(String cid, int pageNumber, int pageSize) {
        //调用dao层方法并捕获异常
       int totalRecord;
        PageBean<Product> productPageBean =null;
        try {
            //获取总记录数
            totalRecord = productDao.findByCid(cid);
            //创建pageBean对象
             productPageBean = new PageBean<>(pageNumber, pageSize, totalRecord);
            //将数据进行分页 并且把数据放在pageBean对象的list中去
            List<Product> productList =productDao.findAllByCid(cid, productPageBean.getStartIndex(), productPageBean.getPageSize());
            System.out.println(productList);
            productPageBean.setData(productList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productPageBean;
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
