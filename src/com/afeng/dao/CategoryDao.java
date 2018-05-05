package com.afeng.dao;

import com.afeng.domain.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
    List<Category> findAll() throws SQLException;
}
