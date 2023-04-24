package com.sahil.servermanager.exceptionHandler.exceptions;

import org.springframework.http.HttpStatus;

/**
 * New Exception class to throw when some data in a json is missing
 */
public class FormatNotCorrectException extends RuntimeException {
    public final HttpStatus statusCode = HttpStatus.BAD_REQUEST;

    public FormatNotCorrectException(String message) {
        super(message);
    }

    public FormatNotCorrectException(String message, Throwable cause) {
        super(message, cause);
    }
}
