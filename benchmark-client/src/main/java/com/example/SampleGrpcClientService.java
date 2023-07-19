package com.example;

import com.benchmarking.grpc.GetRequest;
import com.benchmarking.grpc.GetResponse;
import com.benchmarking.grpc.SampleServiceGrpc;
import com.google.j2objc.annotations.Property;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SampleGrpcClientService {
    @Value("grpcServer")
    private String grpcServer;
    private final SampleServiceGrpc.SampleServiceBlockingStub sampleServiceBlockingStub;

    public SampleGrpcClientService() {
        ManagedChannel channel = Grpc.newChannelBuilder(
                        grpcServer,
                        InsecureChannelCredentials.create())
                .build();

        this.sampleServiceBlockingStub = SampleServiceGrpc.newBlockingStub(channel);
    }

    public GetResponse get() {
        return sampleServiceBlockingStub.get(GetRequest.newBuilder().build());
    }
}