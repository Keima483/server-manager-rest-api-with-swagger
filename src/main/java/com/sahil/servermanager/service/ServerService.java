package com.sahil.servermanager.service;

import com.sahil.servermanager.entity.Server;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Class Containing all the services which we can take from the services collection
 */
public interface ServerService {

    /**
     * @return List of all servers
     */
    public List<Server> getALlServers();

    /**
     * @param id of the server that is being searched
     * @return the server of the given id or if not found throws exception
     */
    public Server getServer(String id);

    /**
     * This method will add the server it takes to the database and if
     * its already present then it will be updated.
     * @param server that needs to be added or updated
     * @return the updated or added server object
     */
    public Server putServer(Server server);

    /**
     * This method will delete the server with the given id
     * @param id of the server that needs to be deleted
     */
    public void deleteServer(String id);

    /**
     * This method will take the name of the server and search for it in all the server name
     * and will return a list of servers which have the name in there name
     * @param name of the server
     * @return list of server in the name of which the name in the parameter comes
     */
    public List<Server> findByName(String name);
}
