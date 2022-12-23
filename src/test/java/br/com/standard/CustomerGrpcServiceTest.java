package br.com.standard;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Duration;

import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

@QuarkusTest
public class CustomerGrpcServiceTest {

    @GrpcClient
    CustomerGrpc customerGrpc;

    @Test
    public void testHello() {
        var customer = CreateCustomerRequest
            .newBuilder()
            .setName("Neo")
            .setEmail("teste@hotmail.com")
            .setPhone("1100000000")
            .build();

        var reply = customerGrpc
            .create(customer)
            .await()
            .atMost(Duration.ofSeconds(5));

        assertNotNull(reply.getId());
    }

}
