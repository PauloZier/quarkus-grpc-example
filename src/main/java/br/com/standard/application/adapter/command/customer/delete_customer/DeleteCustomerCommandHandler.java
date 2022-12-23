package br.com.standard.application.adapter.command.customer.delete_customer;

import br.com.standard.application.port.command.CommandHandler;
import br.com.standard.domain.port.repository.CustomerRepository;

public class DeleteCustomerCommandHandler implements CommandHandler<DeleteCustomerCommand, Void> {

    private final CustomerRepository repository;

    public DeleteCustomerCommandHandler(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Void handle(DeleteCustomerCommand request) {
        repository.delete(request.getId());
        return null;
    }
}
