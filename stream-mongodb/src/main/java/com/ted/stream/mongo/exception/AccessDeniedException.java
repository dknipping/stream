package com.ted.stream.mongo.exception;

public class AccessDeniedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AccessDeniedException(String message) {
        super(message);
    }
    
    public AccessDeniedException(Exception cause) {
        super(cause);
    }
    
    public AccessDeniedException(String message, Exception cause) {
        super(message, cause);
    }
}
