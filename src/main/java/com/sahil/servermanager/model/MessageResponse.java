package com.sahil.servermanager.model;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Model class for when a message is need to be sent as response
 */
@Data
@AllArgsConstructor
public class MessageResponse {

    public String message;
}