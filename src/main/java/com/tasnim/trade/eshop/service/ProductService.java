package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.to.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);

    List<Product> findAll();

    List<Product> findAll(int page, int size);

    void delete(Long id);

    void delete(Product product);
}
