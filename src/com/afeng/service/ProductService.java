package com.afeng.service;

import com.afeng.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findByHot();

    List<Product> findByNew();
}
