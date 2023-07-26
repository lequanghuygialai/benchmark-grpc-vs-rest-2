package com.example;

import com.benchmarking.grpc.*;
import io.grpc.stub.StreamObserver;

public class SampleService{
    static class SampleServiceGrpcImpl extends SampleServiceGrpc.SampleServiceImplBase {
        @Override
        public void get(GetRequest request, StreamObserver<GetResponse> responseObserver) {
            responseObserver.onNext(GetResponse.newBuilder().setResult(request.getNumber()).build());
            responseObserver.onCompleted();
        }
    }
}

