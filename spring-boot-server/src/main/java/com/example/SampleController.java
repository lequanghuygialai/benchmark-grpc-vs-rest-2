package com.example;

import com.benchmarking.grpc.GetResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping(path = "/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetResponse get(@PathVariable int number) {
        return GetResponse.newBuilder().setResult(number).build();
    }
}
