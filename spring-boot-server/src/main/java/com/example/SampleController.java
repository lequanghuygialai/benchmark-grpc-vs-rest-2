package com.example;

import com.benchmarking.grpc.GetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @Autowired
    SampleService sampleService;

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetResponse get() {
        return GetResponse.newBuilder().addAllBigObjects(sampleService.getBigObjects()).build();
    }
}
