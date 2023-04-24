package com.sahil.servermanager.exceptionHandler;

import com.sahil.servermanager.exceptionHandler.exceptions.FormatNotCorrectException;
import com.sahil.servermanager.exceptionHandler.exceptions.ServerNotFoundException;
import com.sahil.servermanager.model.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * A class which will catch any exception raised and return appropriate response
 */
@ControllerAdvice
public class ApiExceptionHandler {

    /**
     * Takes the error of type ServerNotFoundException and return a proper response with status code
     * @param serverNotFoundException the exception when a server is not found
     * @return message response of what went wrong along with the status code
     */
    @ExceptionHandler(value = { ServerNotFoundException.class })
    public ResponseEntity<MessageResponse> handleNotFoundException(ServerNotFoundException serverNotFoundException) {
        MessageResponse messageResponse = new MessageResponse(serverNotFoundException.getMessage());
        return new ResponseEntity<>(messageResponse, serverNotFoundException.statusCode);
    }

    /**
     * Takes the error of type FormatNotCorrectException and return a proper response with status code
     * @param formatNotCorrectException the exception when JSON formatting is not correct
     * @return message response of what went wrong along with the status code
     */
    @ExceptionHandler(value = { FormatNotCorrectException.class })
    public ResponseEntity<MessageResponse> handleNotValidException(FormatNotCorrectException formatNotCorrectException) {
        MessageResponse messageResponse = new MessageResponse(formatNotCorrectException.getMessage());
        return new ResponseEntity<>(messageResponse, formatNotCorrectException.statusCode);
    }
}
