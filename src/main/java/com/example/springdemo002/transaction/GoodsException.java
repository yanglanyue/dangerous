package com.example.springdemo002.transaction;


//自定义一个异常
public class GoodsException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public GoodsException() {
    }

    public GoodsException(String message) {
        super(message);
    }

    public GoodsException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoodsException(Throwable cause) {
        super(cause);
    }

    public GoodsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
