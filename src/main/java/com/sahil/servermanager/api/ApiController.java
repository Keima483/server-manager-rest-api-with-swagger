package com.sahil.servermanager.api;

import com.sahil.servermanager.entity.Server;
import com.sahil.servermanager.model.MessageResponse;
import com.sahil.servermanager.service.ServerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is the API layer of this application and is responsible
 * for handling all the API request and calling the designates method
 * according to the request method.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/server")
public class ApiController {

    // Dependency injection(with constructor by @RequiredArgsConstructor)
    // of service class to interact with the service layer
    private final ServerService serverService;

    /**
     * GET http://localhost:8080/api/v1/server <br>
     * Takes in nothing and returns a list of all servers
     * @return List of Servers
     */
    @GetMapping
    public ResponseEntity<List<Server>> getAllServers() {
        return new ResponseEntity<>(serverService.getALlServers(), HttpStatus.OK);
    }

    /**
     * GET http://localhost:8080/api/v1/server/{id} <br>
     * Takes the id of a server as path variable and returns
     * the server object of that id or not found message if
     * server of that id not found
     * @param id of the server as path variable
     * @return Server
     */
    @GetMapping("/{id}")
    public ResponseEntity<Server> getServer(@PathVariable String id) {
        return new ResponseEntity<>(serverService.getServer(id), HttpStatus.OK);
    }

    /**
     * PUT http://localhost:8080/api/v1/server <br>
     * Takes the server object in JSON form and adds it to the database
     * if not already exists, if it exists then update
     * @param server that needs to be added or updated
     * @return the updated or newly added server object
     */
    @PutMapping
    public ResponseEntity<Server> putUser(@RequestBody Server server) {
        return new ResponseEntity<>(serverService.putServer(server), HttpStatus.OK);
    }

    /**
     * DELETE http://localhost:8080/api/v1/server/{id} <br>
     * Takes the id of a server as path variable and deletes it if its present
     * @param id of the server that needs to be deleted
     * @return String message of weather the server is deleted or not
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteServer(@PathVariable String id) {
        serverService.deleteServer(id);
        return new ResponseEntity<>(new MessageResponse("Server of id: " + id + " is deleted"), HttpStatus.OK);
    }

    /**
     * GET http://localhost:8080/api/v1/server/find?name={name} <br>
     * Takes a string from the request param and search for server names that
     * contain that string and then returns a list of them
     * @param name takes the string which needs to be searched for among server names
     * @return list of server names which contains the provided name
     */
    @GetMapping("/find")
    public ResponseEntity<List<Server>> findServerByName(@RequestParam String name) {
        return new ResponseEntity<>(serverService.findByName(name), HttpStatus.OK);
    }
}
