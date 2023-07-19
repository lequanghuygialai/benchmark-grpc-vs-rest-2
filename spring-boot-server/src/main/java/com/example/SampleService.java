package com.example;

import com.benchmarking.grpc.BigObject;
import org.springframework.stereotype.Service;
import services.BigObjectService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SampleService {
    static List<BigObject> bigObjects = new ArrayList<>();

    public SampleService() {
        init();
    }

    public void init() {
        if (bigObjects.isEmpty()) {
            for (int i = 0; i < 100; i++) {
                com.benchmarking.grpc.BigObject bigObject = BigObjectService.GenerateBigObject.build();
                bigObjects.add(bigObject);
            }
        }
    }

    public List<BigObject> getBigObjects() {
        return bigObjects;
    }
}
