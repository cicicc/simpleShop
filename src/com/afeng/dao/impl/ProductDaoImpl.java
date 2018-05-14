package com.afeng.dao.impl;

import com.afeng.dao.ProductDao;
import com.afeng.domain.Product;
import com.afeng.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

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

        return queryRunner.query(sql, new BeanListHandler<>(Product.class),1,0,9);
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
        return queryRunner.query(sql, new BeanListHandler<>(Product.class),0,9);
    }

    /**
     *根据service层传递过来的cid查询数据库中对应的商品数目 并返回
     * @param cid 查询所属的分类
     * @return 查询到的商品数目
     */
    @Override
    public int findByCid(String cid) throws SQLException {
        //创建queryRunner对象
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        //书写sql语句
        String sql = "select count(*) from product where cid=?";
        Long count =(Long)queryRunner.query(sql,new ScalarHandler(),cid);
        return count.intValue();
    }
    /**
     *根据service层传递过来的pid查询数据库中对应的商品 并返回
     * @param pid 查询的商品
     * @return 查询到的商品
     */
    @Override
    public Product findByPid(String pid) throws SQLException {
        //获取queryRunner对象
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        //书写sql语句
        String sql = "select * from product where pid=?";
        //查询数据库 并返回结果

        return queryRunner.query(sql, new BeanHandler<>(Product.class), pid);
    }

    /**
     * 根据service层传递过来的cid查询数据库中对应的商品 并返回
     * @param cid 查询结果所属的分类
     * @param startIndex 起始页数
     * @param pageSize 页面数据数目
     * @return 商品列表
     */
    @Override
    public List<Product> findAllByCid(String cid, int startIndex, int pageSize) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where cid = ? order by pdate desc limit ?,?";
        return queryRunner.query(sql,new BeanListHandler<>(Product.class),cid,startIndex,pageSize);
    }
}
