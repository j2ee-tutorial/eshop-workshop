package com.tasnim.trade.eshop.api;

import com.tasnim.trade.eshop.dto.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryService {
    ProductCategory save(ProductCategory productCategory);

    List<ProductCategory> findAll();

    Page<ProductCategory> findAll(Pageable pageable);

    void delete(Long id);

    void delete(ProductCategory productCategory);

    Optional<ProductCategory> findById(Long id);
}
