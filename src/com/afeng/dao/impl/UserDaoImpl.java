package com.afeng.dao.impl;

import com.afeng.dao.UserDao;
import com.afeng.domain.User;
import com.afeng.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {


    @Override
    public void register(User user) throws SQLException {
        //创建queryRunner对象
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        //书写SQL语句
        String sql = "insert into User(id,username,password,name,emil,birthday,sex) values(?,?,?,?,?,?,?)";

        queryRunner.update(sql, user.getUid(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(),
                user.getBirthday(), user.getSex());

    }

    @Override
    public User verifyUsername(String username) throws SQLException {
        //创建queryRunner对象
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        //书写SQL语句
        String sql = "select * from user where username=?";
        //执行查询
        User user = queryRunner.query(sql, new BeanHandler<>(User.class), username);
        //System.out.println(user);
        return user;
    }
}
