package com.javaguru.EmailNotificationService.exception;

public class NonRetryableException extends RuntimeException{
    public NonRetryableException(String message) {
        super(message);
    }

    public NonRetryableException(Throwable cause) {
        super(cause);
    }
}
