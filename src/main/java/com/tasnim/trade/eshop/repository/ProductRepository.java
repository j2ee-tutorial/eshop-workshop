package com.tasnim.trade.eshop.repository;

import com.tasnim.trade.eshop.to.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
