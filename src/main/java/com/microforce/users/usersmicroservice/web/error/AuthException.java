package com.microforce.users.usersmicroservice.web.error;

public class AuthException extends RuntimeException {
    public AuthException(String message) {
        super(message);
    }
}
