package com.example;

import com.benchmarking.grpc.GetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @Autowired
    SampleGrpcClientService sampleGrpcClientService;

    @Autowired
    SampleRestClientService sampleRestClientService;
    @RequestMapping(path = "/grpc", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetResponse grpcGet() throws InterruptedException {
        return sampleGrpcClientService.get();
    }

    @RequestMapping(path = "/rest", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetResponse restGet() {
        return sampleRestClientService.getBigObjects();
    }
}
