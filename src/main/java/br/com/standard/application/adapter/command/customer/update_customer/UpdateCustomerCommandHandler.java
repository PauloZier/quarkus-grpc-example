package br.com.standard.application.adapter.command.customer.update_customer;

import br.com.standard.application.port.command.CommandHandler;
import br.com.standard.domain.entity.Customer;
import br.com.standard.domain.port.repository.CustomerRepository;

public class UpdateCustomerCommandHandler implements CommandHandler<UpdateCustomerCommand, UpdateCustomerCommandResult> {

    private final CustomerRepository repository;

    public UpdateCustomerCommandHandler(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public UpdateCustomerCommandResult handle(UpdateCustomerCommand request) {
        var customer = new Customer(request.getId(), request.getName(), request.getEmail(), request.getPhone());
        repository.save(customer);
        return UpdateCustomerCommandResult.of(customer);
    }
}
