package com.tasnim.trade.eshop.repository;

import com.tasnim.trade.eshop.to.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class ProductCategoryImpl implements ProductCategoryDao{

    @Autowired
    EntityManager entityManager;

    void findByExample(){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductCategory> query = builder.createQuery(ProductCategory.class);
        Root<ProductCategory> from = query.from(ProductCategory.class);
        CriteriaQuery<ProductCategory> select = query.select(from);
        select.orderBy(builder.asc(from.get("name")));
        TypedQuery<ProductCategory> typedQuery = entityManager.createQuery(select);
        List<ProductCategory> productCategories = typedQuery.getResultList();
    }

}

