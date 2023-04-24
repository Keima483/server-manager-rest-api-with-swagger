package com.sahil.servermanager.exceptionHandler.exceptions;

import org.springframework.http.HttpStatus;

/**
 * New Exception to throw when the server is not found
 */
public class ServerNotFoundException extends RuntimeException{

    public final HttpStatus statusCode = HttpStatus.NOT_FOUND;

    public ServerNotFoundException(String message) {
        super(message);
    }

    public ServerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
