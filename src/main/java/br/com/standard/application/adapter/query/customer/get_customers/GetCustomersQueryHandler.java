package br.com.standard.application.adapter.query.customer.get_customers;

import java.util.List;

import br.com.standard.domain.entity.Customer;
import br.com.standard.domain.port.repository.CustomerRepository;

public class GetCustomersQueryHandler {
    
    private final CustomerRepository repository;

    public GetCustomersQueryHandler(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> handle(GetCustomersQuery query) {
        return repository.findAll();
    }
}
