package com.tasnim.trade.eshop.api;

import com.tasnim.trade.eshop.dto.Product;
import com.tasnim.trade.eshop.dto.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Product save(Product product);

    List<Product> findAll();

    Page<Product> findAll(Pageable pageable);

    Page<Product> findAllByCategory(ProductCategory productCategory, Pageable pageable);

    void delete(Long id);

    void delete(Product product);

    List<Product> getTopProducts();
}
