package com.tasnim.trade.eshop.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "PRODUCT_SEQ")
public class Product extends EntityBase {

    @Column(name = "NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
