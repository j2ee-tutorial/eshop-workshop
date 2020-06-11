package com.tasnim.trade.eshop.repository;

import com.tasnim.trade.eshop.to.Product;
import com.tasnim.trade.eshop.to.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, ProductDao, JpaSpecificationExecutor<Product> {
    Product findByName(String name);

    Page<Product> findAll(Pageable pageable);

    Page<Product> findAllByCategory(ProductCategory productCategory, Pageable pageable);

    List<Product> findAllByCategory(ProductCategory productCategory);

    List<Product> findByName(String name, Pageable pageable);
}
