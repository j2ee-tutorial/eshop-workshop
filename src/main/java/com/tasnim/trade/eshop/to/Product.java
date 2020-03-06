package com.tasnim.trade.eshop.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "product_seq")
public class Product extends EntityBase {

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
