package com.tasnim.trade.eshop.repository;

import com.tasnim.trade.eshop.to.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductName(String productName);

    Page<Product> findAll(Pageable pageable);

    List<Product> findByProductName(String name, Pageable pageable);
}