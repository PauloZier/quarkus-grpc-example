package br.com.standard.infrastructure.configuration;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

import br.com.standard.application.adapter.query.customer.get_customer_by_id.GetCustomerByIdQueryHandler;
import br.com.standard.application.adapter.query.customer.get_customers.GetCustomersQueryHandler;
import br.com.standard.domain.port.repository.CustomerRepository;

public class QueryHandlerConfiguration {
    
    @Produces
    @RequestScoped
    public GetCustomersQueryHandler getGetCustomersQueryHandler(CustomerRepository repository) {
        return new GetCustomersQueryHandler(repository);
    }

    @Produces
    @RequestScoped
    public GetCustomerByIdQueryHandler getGetCustomerByIdQueryHandler(CustomerRepository repository) {
        return new GetCustomerByIdQueryHandler(repository);
    }
}
