package com.tasnim.trade.eshop.repository;

import com.tasnim.trade.eshop.to.Product;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class ProductRepositoryImpl implements ProductRepositoryDao {

    @Autowired
    EntityManager entityManager;

    @Override
    public void remove(Product product) {
        entityManager.remove(product);
    }
}
