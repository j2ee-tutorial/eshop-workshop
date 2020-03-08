package com.tasnim.trade.eshop.dto;

public class DtoBase {

    private Long id;

    private final AuditDto auditDto;

    DtoBase() {
        this.auditDto = new AuditDto();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuditDto getAuditDto() {
        return auditDto;
    }
}
