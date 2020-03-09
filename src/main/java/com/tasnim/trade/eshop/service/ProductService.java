package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.to.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Product save(Product product);

    List<Product> findAll();

    Page<Product> findAll(Pageable pageable);

    void delete(Long id);

    void delete(Product product);
}
