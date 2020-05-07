package com.tasnim.trade.eshop.type;

public enum ErrorCode {
    SUCCESSFUL(0, "Operation successful");

    private final Integer code;
    private final String description;

    ErrorCode(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
