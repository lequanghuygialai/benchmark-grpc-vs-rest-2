package com.example;

import com.benchmarking.grpc.GetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SampleRestClientService {
    @Value("getSpringBootServer")
    private String getSpringBootServer;
    @Autowired
    RestTemplate restTemplate;

    public GetResponse getBigObjects() {
        return restTemplate.getForObject(getSpringBootServer, GetResponse.class);
    }
}

