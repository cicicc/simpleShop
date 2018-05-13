package com.afeng.dao;

import com.afeng.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    List<Product> findByHot() throws SQLException;

    List<Product> findByNew() throws SQLException;

    List<Product> findByCid( String cid) throws SQLException;

    Product findByPid(String pid) throws SQLException;
}
