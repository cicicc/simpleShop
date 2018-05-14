package com.afeng.service;

import com.afeng.domain.Product;
import com.afeng.domain.PageBean;

import java.util.List;

public interface ProductService {
    List<Product> findByHot();

    List<Product> findByNew();



    Product findByPid(String pid);

    PageBean<Product> findByCid(String cid, int pageNumber, int pageSize);
}
