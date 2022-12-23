package br.com.standard.infrastructure.configuration;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.validation.Validator;

import br.com.standard.application.adapter.command.customer.create_customer.CreateCustomerCommandHandler;
import br.com.standard.application.adapter.command.customer.delete_customer.DeleteCustomerCommandHandler;
import br.com.standard.application.adapter.command.customer.update_customer.UpdateCustomerCommandHandler;
import br.com.standard.application.adapter.query.customer.get_customer_by_id.GetCustomerByIdQueryHandler;
import br.com.standard.application.adapter.query.customer.get_customers.GetCustomersQueryHandler;
import br.com.standard.application.adapter.service.CustomerServiceImpl;
import br.com.standard.application.port.service.CustomerService;

public class ServiceConfiguration {

    @Produces
    @RequestScoped
    public CustomerService getCustomerService(Validator validator,
            CreateCustomerCommandHandler createCustomerCommandHandler,
            UpdateCustomerCommandHandler updateCustomerCommandHandler,
            DeleteCustomerCommandHandler deleteCustomerCommandHandler,
            GetCustomerByIdQueryHandler getCustomerByIdQueryHandler,
            GetCustomersQueryHandler getCustomersQueryHandler) {

        return new CustomerServiceImpl(validator,
            createCustomerCommandHandler, 
            updateCustomerCommandHandler, 
            deleteCustomerCommandHandler, 
            getCustomerByIdQueryHandler, 
            getCustomersQueryHandler);
    }
}
