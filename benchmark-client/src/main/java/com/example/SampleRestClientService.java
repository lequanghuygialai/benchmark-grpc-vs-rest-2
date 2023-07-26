package com.example;

import com.benchmarking.grpc.GetResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class SampleRestClientService {
    @Autowired
    private ApplicationProps applicationProps;
    @Autowired
    RestTemplate restTemplate;

    public Map<Integer, Integer> get(int number) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < number; i++) {
            map.put(i, restTemplate.getForObject(applicationProps.getSpringBootServer() + "/" + i, GetResponse.class).getResult());
        }
        return map;
    }
}

