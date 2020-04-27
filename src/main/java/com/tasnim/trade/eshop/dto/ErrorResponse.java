package com.tasnim.trade.eshop.dto;

import com.tasnim.trade.eshop.type.ErrorCode;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse<T> extends Response {
    private final List<T> errorDetails = new ArrayList<>();

    public ErrorResponse(ErrorCode errorCode) {
        super(errorCode);
    }

    public void addErrorDetail(T errorDetail) {
        errorDetails.add(errorDetail);
    }
}
