package com.example;

import com.benchmarking.grpc.GetRequest;
import com.benchmarking.grpc.SampleServiceGrpc;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class SampleGrpcClientService implements InitializingBean {
    @Autowired
    private ApplicationProps applicationProps;

    private SampleServiceGrpc.SampleServiceBlockingStub sampleServiceBlockingStub = null;

    @Override
    public void afterPropertiesSet() throws Exception {
        ManagedChannel channel = Grpc.newChannelBuilder(
                        applicationProps.getGrpcServer(),
                        InsecureChannelCredentials.create())
                .build();

        sampleServiceBlockingStub = SampleServiceGrpc.newBlockingStub(channel);
    }

    public Map<Integer, Integer> get(int number) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < number; i++) {
            map.put(i, sampleServiceBlockingStub.get(GetRequest.newBuilder().setNumber(i).build()).getResult());
        }

        return map;
    }
}