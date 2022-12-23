package br.com.standard.application.adapter.service;

import java.util.List;

import br.com.standard.application.adapter.command.customer.create_customer.CreateCustomerCommand;
import br.com.standard.application.adapter.command.customer.create_customer.CreateCustomerCommandHandler;
import br.com.standard.application.adapter.command.customer.create_customer.CreateCustomerCommandResult;
import br.com.standard.application.adapter.command.customer.delete_customer.DeleteCustomerCommand;
import br.com.standard.application.adapter.command.customer.delete_customer.DeleteCustomerCommandHandler;
import br.com.standard.application.adapter.command.customer.update_customer.UpdateCustomerCommand;
import br.com.standard.application.adapter.command.customer.update_customer.UpdateCustomerCommandHandler;
import br.com.standard.application.adapter.command.customer.update_customer.UpdateCustomerCommandResult;
import br.com.standard.application.adapter.query.customer.get_customer_by_id.GetCustomerByIdQuery;
import br.com.standard.application.adapter.query.customer.get_customer_by_id.GetCustomerByIdQueryHandler;
import br.com.standard.application.adapter.query.customer.get_customers.GetCustomersQuery;
import br.com.standard.application.adapter.query.customer.get_customers.GetCustomersQueryHandler;
import br.com.standard.application.port.service.CustomerService;
import br.com.standard.domain.entity.Customer;

public class CustomerServiceImpl implements CustomerService {
    
    private final CreateCustomerCommandHandler createCustomerCommandHandler;
    private final UpdateCustomerCommandHandler updateCustomerCommandHandler;
    private final DeleteCustomerCommandHandler deleteCustomerCommandHandler;
    private final GetCustomerByIdQueryHandler getCustomerByIdQueryHandler;
    private final GetCustomersQueryHandler getCustomersQueryHandler;

    public CustomerServiceImpl(CreateCustomerCommandHandler createCustomerCommandHandler,
            UpdateCustomerCommandHandler updateCustomerCommandHandler,
            DeleteCustomerCommandHandler deleteCustomerCommandHandler,
            GetCustomerByIdQueryHandler getCustomerByIdQueryHandler,
            GetCustomersQueryHandler getCustomersQueryHandler) {
        this.createCustomerCommandHandler = createCustomerCommandHandler;
        this.updateCustomerCommandHandler = updateCustomerCommandHandler;
        this.deleteCustomerCommandHandler = deleteCustomerCommandHandler;
        this.getCustomerByIdQueryHandler = getCustomerByIdQueryHandler;
        this.getCustomersQueryHandler = getCustomersQueryHandler;
    }

    public CreateCustomerCommandResult send(CreateCustomerCommand command) {
        return this.createCustomerCommandHandler.handle(command);
    }

    public UpdateCustomerCommandResult send(UpdateCustomerCommand command) {
        return this.updateCustomerCommandHandler.handle(command);
    }

    public void send(DeleteCustomerCommand command) {
        this.deleteCustomerCommandHandler.handle(command);
    }

    public List<Customer> query(GetCustomersQuery query) {
        return this.getCustomersQueryHandler.handle(query);
    }

    public Customer query(GetCustomerByIdQuery query) {
        return this.getCustomerByIdQueryHandler.handle(query);
    }
}
