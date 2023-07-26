package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SampleController {
    @Autowired
    SampleGrpcClientService sampleGrpcClientService;

    @Autowired
    SampleRestClientService sampleRestClientService;

    @RequestMapping(path = "/grpc/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<Integer, Integer> grpcGet(@PathVariable int number) {
        return sampleGrpcClientService.get(number);

    }

    @RequestMapping(path = "/rest/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<Integer, Integer> restGet(@PathVariable int number) {
        return sampleRestClientService.get(number);
    }
}
