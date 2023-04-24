package com.sahil.servermanager.repository;

import com.sahil.servermanager.entity.Server;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * JPA interface for the server collection
 */
public interface ServerRepository extends MongoRepository<Server, String> {
    public List<Server> findServersByNameContainingIgnoreCase(String name);
}
