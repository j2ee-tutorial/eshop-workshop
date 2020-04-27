package com.tasnim.trade.eshop.dto;

import com.tasnim.trade.eshop.type.ErrorCode;

public class SuccessfulResponse<T /*extends EntityBase*/> extends Response {

    private final T result;

    public SuccessfulResponse(T result) {
        super(ErrorCode.SUCCESSFUL);
        this.result = result;
    }

    public T getResult() {
        return result;
    }
}
