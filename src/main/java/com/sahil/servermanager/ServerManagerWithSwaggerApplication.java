package com.sahil.servermanager;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Server Manager REST API",
                version = "1.0.0",
                description = "A spring boot application to provide REST API endpoints for managing servers with mongoDB as the database",
                contact = @Contact(
                        name = "Sahil Verma",
                        email = "vermasahil78910@gmail.com"
                )
        )
)
@SpringBootApplication
public class ServerManagerWithSwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerManagerWithSwaggerApplication.class, args);
    }
}
