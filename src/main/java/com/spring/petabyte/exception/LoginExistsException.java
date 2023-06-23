package com.spring.petabyte.exception;

public class LoginExistsException extends RuntimeException {
    public LoginExistsException() {
    }

    public LoginExistsException(String message) {
        super(message);
    }
}
