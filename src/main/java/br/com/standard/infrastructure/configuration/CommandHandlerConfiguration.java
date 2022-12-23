package br.com.standard.infrastructure.configuration;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

import br.com.standard.application.adapter.command.customer.create_customer.CreateCustomerCommandHandler;
import br.com.standard.application.adapter.command.customer.delete_customer.DeleteCustomerCommandHandler;
import br.com.standard.application.adapter.command.customer.update_customer.UpdateCustomerCommandHandler;
import br.com.standard.domain.port.repository.CustomerRepository;

public class CommandHandlerConfiguration {
    
    @Produces
    @RequestScoped
    public CreateCustomerCommandHandler getCreateCustomerCommandHandler(CustomerRepository repository) {
        return new CreateCustomerCommandHandler(repository);
    }

    @Produces
    @RequestScoped
    public UpdateCustomerCommandHandler getUpdateCustomerCommandHandler(CustomerRepository repository) {
        return new UpdateCustomerCommandHandler(repository);
    }

    @Produces
    @RequestScoped
    public DeleteCustomerCommandHandler getDeleteCustomerCommandHandler(CustomerRepository repository) {
        return new DeleteCustomerCommandHandler(repository);
    }
}
