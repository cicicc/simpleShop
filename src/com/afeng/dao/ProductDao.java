package com.afeng.dao;

import com.afeng.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    List<Product> findByHot() throws SQLException;

    List<Product> findByNew() throws SQLException;

    int findByCid(String cid) throws SQLException;

    Product findByPid(String pid) throws SQLException;

    List<Product> findAllByCid(String cid, int startIndex, int pageSize) throws SQLException;
}
