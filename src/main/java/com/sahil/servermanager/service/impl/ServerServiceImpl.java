package com.sahil.servermanager.service.impl;

import com.sahil.servermanager.entity.Server;
import com.sahil.servermanager.exceptionHandler.exceptions.FormatNotCorrectException;
import com.sahil.servermanager.exceptionHandler.exceptions.ServerNotFoundException;
import com.sahil.servermanager.repository.ServerRepository;
import com.sahil.servermanager.service.ServerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of ServerService interface which is a collection of
 * all the services provided on the servers collection
 */
@Service
@RequiredArgsConstructor
public class ServerServiceImpl implements ServerService {

    // instance of ServerRepository which will be
    // injected through constructor injection
    private final ServerRepository serverRepository;

    @Override
    public List<Server> getALlServers() {
        return serverRepository.findAll();
    }

    @Override
    public Server getServer(String id) {
        var serverData = serverRepository.findById(id);
        if(serverData.isPresent()) {
            return serverData.get();
        }
        throw new ServerNotFoundException("No server found of the given id");
    }

    @Override
    public Server putServer(Server server) {
        if(Server.isValid(server)) {
            return serverRepository.save(server);
        }
        throw new FormatNotCorrectException("The format of the JSON doesn't match");
    }

    @Override
    public void deleteServer(String id) {
        var serverData = serverRepository.findById(id);
        if(serverData.isPresent()) {
            serverRepository.deleteById(id);
            return;
        }
        throw new ServerNotFoundException("No server found of the given id");
    }

    @Override
    public List<Server> findByName(String name) {
        var services = serverRepository.findServersByNameContainingIgnoreCase(name);
        if(services.isEmpty()) {
            throw new ServerNotFoundException("No server with this name");
        }
        return services;
    }
}
