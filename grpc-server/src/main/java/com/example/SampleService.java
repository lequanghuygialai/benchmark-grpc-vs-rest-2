package com.example;

import com.benchmarking.grpc.*;
import io.grpc.stub.StreamObserver;
import services.BigObjectService;

import java.util.ArrayList;
import java.util.List;

public class SampleService{
    static class SampleServiceGrpcImpl extends SampleServiceGrpc.SampleServiceImplBase {
        static List<BigObject> bigObjects = new ArrayList<>();

        public SampleServiceGrpcImpl() {
            init();
        }

        public void init() {
            if (bigObjects.isEmpty()) {
                for (int i = 0; i < 100; i++) {
                    BigObject bigObject = BigObjectService.GenerateBigObject.build();
                    bigObjects.add(bigObject);
                }
            }
        }

        @Override
        public void get(GetRequest request, StreamObserver<GetResponse> responseObserver) {
            responseObserver.onNext(GetResponse.newBuilder().addAllBigObjects(bigObjects).build());
            responseObserver.onCompleted();
        }
    }
}

