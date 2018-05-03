package com.afeng.dao.impl;

import com.afeng.dao.UserDao;
import com.afeng.domain.User;
import com.afeng.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {


    @Override
    public int register(User user) throws SQLException {
        //创建queryRunner对象
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        //书写SQL语句
        String sql = "insert into User(uid,username,password,name,email,birthday,sex,state,code) values(?,?,?,?,?,?,?,?,?)";
        //执行插入语句 并将成功与否的结果返回service层对象
        int registerRes = queryRunner.update(sql, user.getUid(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(),
                user.getBirthday(), user.getSex(), user.getState(), user.getCode());
        //System.out.println(registerRes);
        return registerRes;
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

    @Override
    public Integer active(String activeCode) throws SQLException {
        //创建queryRunner对象
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        //书写SQL语句
        String sql = "update user set state=1 where code=?";
        //执行SQL语句 将状态设为1 这样便激活了用户
        int updateRes = queryRunner.update(sql, activeCode);
        return updateRes;
    }
}
