package com.tasnim.trade.eshop.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "ROLE_SEQ")
public class Role extends EntityBase {

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    @Column(name = "name", length = 200)
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
