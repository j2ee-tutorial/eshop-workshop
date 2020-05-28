package com.tasnim.trade.eshop.repository;

import com.tasnim.trade.eshop.to.Product;
import com.tasnim.trade.eshop.to.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    List<ProductCategory> findByName(String name);

    Page<ProductCategory> findAll(Pageable pageable);

    List<ProductCategory> findByName(String name, Pageable pageable);
}
