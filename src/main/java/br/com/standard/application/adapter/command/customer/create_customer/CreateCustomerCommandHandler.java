package br.com.standard.application.adapter.command.customer.create_customer;

import br.com.standard.application.port.command.CommandHandler;
import br.com.standard.domain.entity.Customer;
import br.com.standard.domain.port.repository.CustomerRepository;

public class CreateCustomerCommandHandler implements CommandHandler<CreateCustomerCommand, CreateCustomerCommandResult> {

    private final CustomerRepository repository;

    public CreateCustomerCommandHandler(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateCustomerCommandResult handle(CreateCustomerCommand request) {
        var customer = new Customer(null, request.getName(), request.getEmail(), request.getPhone());
        customer = this.repository.save(customer);
        return CreateCustomerCommandResult.of(customer);
    }
}
