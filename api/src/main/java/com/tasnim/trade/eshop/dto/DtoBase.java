package com.tasnim.trade.eshop.dto;

import com.tasnim.trade.eshop.dto.base.Audit;

public abstract class DtoBase {

    private Long id;

    private final Audit audit;

    DtoBase() {
        this.audit = new Audit();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Audit getAudit() {
        return audit;
    }
}
