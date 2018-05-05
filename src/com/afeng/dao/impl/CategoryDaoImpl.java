package com.afeng.dao.impl;

import com.afeng.dao.CategoryDao;
import com.afeng.domain.Category;
import com.afeng.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    /**
     * 查询所有的商品分类信息并以category对象的形式返回
     * @return 商品分类信息
     * @throws SQLException
     */
    @Override
    public List<Category> findAll() throws SQLException {
        //创建queryRunner对象
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        //书写sql语句
        String sql = "select * from category";
        //执行查询语句 并将所得的对象进行返回
        List<Category> categoryList = queryRunner.query(sql, new BeanListHandler<>(Category.class));
        return categoryList;
    }
}
