package com.example;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class ApplicationProps {
    public String getGrpcServer() {
        return grpcServer;
    }

    public void setGrpcServer(String grpcServer) {
        this.grpcServer = grpcServer;
    }

    public String getSpringBootServer() {
        return springBootServer;
    }

    public void setSpringBootServer(String springBootServer) {
        this.springBootServer = springBootServer;
    }

    private String grpcServer;
    private String springBootServer;
}
