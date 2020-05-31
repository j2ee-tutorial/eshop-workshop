package com.tasnim.trade.eshop.exception;

public class MyDataIntegrityViolationException extends RuntimeException {
    public MyDataIntegrityViolationException() {
        super();
    }

    public MyDataIntegrityViolationException(String message) {
        super(message);
    }

    public MyDataIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyDataIntegrityViolationException(Throwable cause) {
        super(cause);
    }

    protected MyDataIntegrityViolationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
