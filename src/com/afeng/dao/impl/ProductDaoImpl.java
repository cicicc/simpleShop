package com.afeng.dao.impl;

import com.afeng.dao.ProductDao;
import com.afeng.domain.Product;
import com.afeng.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    /**
     * 查询数据库中的热门商品
     * @return 热门商品列表
     */
    @Override
    public List<Product> findByHot() throws SQLException {
        //创建queryRunner对象
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        //书写sql语句
        String sql = "select * from product where is_hot=? and pflag=? order by pdate desc limit ?";
        List<Product> productList = queryRunner.query(sql, new BeanListHandler<>(Product.class),1,0,9);
        return productList;
    }

    /**
     * 查询数据库中的最新商品
     * @return 最新商品列表
     */
    @Override
    public List<Product> findByNew() throws SQLException {
        //创建queryRunner对象
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        //书写sql语句
        String sql = "select * from product where pflag=? order by pdate desc limit ?";
        List<Product> productList = queryRunner.query(sql, new BeanListHandler<>(Product.class),0,9);
        return productList;
    }
}
