package com.sahil.servermanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This class is responsible for defining the structure
 * of the Documents in the servers collection
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "servers")
public class Server {

    private String name;
    private String id;
    private String language;
    private String framework;


    /**
     * Static method to check if a server object is valid to add in the database
     * or not, this is done by checking that none of the fields of the server
     * object is null.
     * @param server object
     * @return boolean value depending on weather its a valid server object or not
     */
    public static boolean isValid(Server server) {
        return server.getName() != null && server.getId() != null && server.getLanguage() != null && server.getFramework() != null;
    }
}
