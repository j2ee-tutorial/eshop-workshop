package com.tasnim.trade.eshop.dto;

import com.tasnim.trade.eshop.type.ErrorCode;

public abstract class Response {
    private final Integer code;
    private final String description;

    public Response(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Response(ErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getDescription());
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
