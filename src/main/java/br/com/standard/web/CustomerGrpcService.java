package br.com.standard.web;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import br.com.standard.CreateCustomerRequest;
import br.com.standard.CustomerGrpc;
import br.com.standard.CustomerReply;
import br.com.standard.DeleteCustomerReply;
import br.com.standard.DeleteCustomerRequest;
import br.com.standard.GetCustomerByIdRequest;
import br.com.standard.GetCustomersReply;
import br.com.standard.GetCustomersRequest;
import br.com.standard.UpdateCustomerRequest;
import br.com.standard.application.adapter.command.customer.create_customer.CreateCustomerCommand;
import br.com.standard.application.adapter.command.customer.delete_customer.DeleteCustomerCommand;
import br.com.standard.application.adapter.command.customer.update_customer.UpdateCustomerCommand;
import br.com.standard.application.adapter.query.customer.get_customer_by_id.GetCustomerByIdQuery;
import br.com.standard.application.adapter.query.customer.get_customers.GetCustomersQuery;
import br.com.standard.application.port.service.CustomerService;
import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;

@Blocking
@GrpcService
public class CustomerGrpcService implements CustomerGrpc {

    private final CustomerService service;

    public CustomerGrpcService(CustomerService service) {
        this.service = service;
    }

    @Override
    @Transactional
    public Uni<CustomerReply> create(CreateCustomerRequest request) {
        
        var command = new CreateCustomerCommand(
                request.getName(), request.getEmail(), request.getPhone());

        var response = this.service.send(command);
        var reply = CustomerReply
            .newBuilder()
            .setId(response.getId())
            .setName(response.getName())
            .setEmail(response.getEmail())
            .setPhone(response.getPhone())
            .build();

        return Uni
            .createFrom()
            .item(reply);
    }

    @Override
    @Transactional
    public Uni<CustomerReply> update(UpdateCustomerRequest request) {
        var command = new UpdateCustomerCommand(
            request.getId(), request.getName(), request.getEmail(), request.getPhone());

        var response = this.service.send(command);
        var reply = CustomerReply
            .newBuilder()
            .setId(response.getId())
            .setName(response.getName())
            .setEmail(response.getEmail())
            .setPhone(response.getPhone())
            .build();

        return Uni
            .createFrom()
            .item(reply);
    }

    @Override
    public Uni<CustomerReply> getById(GetCustomerByIdRequest request) {
        var query = new GetCustomerByIdQuery(request.getId());
        var response = service.query(query);

        var reply = CustomerReply
            .newBuilder()
            .setId(response.getId())
            .setName(response.getName())
            .setEmail(response.getEmail())
            .setPhone(response.getPhone())
            .build();

        return Uni
            .createFrom()
            .item(reply);
    }

    @Override
    public Uni<GetCustomersReply> get(GetCustomersRequest request) {
        var query = new GetCustomersQuery();
        var response = service.query(query);
        var customers = response.stream().map(x -> CustomerReply
            .newBuilder()
            .setId(x.getId())
            .setName(x.getName())
            .setEmail(x.getEmail())
            .setPhone(x.getPhone())
            .build())
            .collect(Collectors.toList());

        var reply = GetCustomersReply
            .newBuilder()
            .addAllCustomers(customers)
            .build();

        return Uni
            .createFrom()
            .item(reply);
    }

    @Override
    @Transactional
    public Uni<DeleteCustomerReply> delete(DeleteCustomerRequest request) {
        var command = new DeleteCustomerCommand(request.getId());
        service.send(command);
        var reply = DeleteCustomerReply
            .newBuilder()
            .setMessage("Success!")
            .setSuccess(true)
            .build();

        return Uni
            .createFrom()
            .item(reply);
    }
}
