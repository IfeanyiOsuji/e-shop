package com.ecommerce.shop.web.exceptions;

public class ProductDoesNotExistException extends RuntimeException {
    public ProductDoesNotExistException() {
    }

    public ProductDoesNotExistException(String s) {
    }

    public ProductDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
