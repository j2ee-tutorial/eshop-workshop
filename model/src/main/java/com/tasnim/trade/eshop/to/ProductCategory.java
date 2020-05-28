package com.tasnim.trade.eshop.to;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCT_CATEGORY")
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "PRODUCT_CATEGORY_SEQ")
public class ProductCategory extends EntityBase {

    public ProductCategory() {
    }

    public ProductCategory(String name) {
        this.name = name;
    }

    @Column(name = "name", length = 200)
    private String name;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "MASTER_CATEGORY")
//    private ProductCategory masterCategory;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

//    @OneToMany(cascade = {CascadeType.PERSIST})
//    private Set<ProductCategory> categories = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }


}
