package br.com.standard.application.adapter.query.customer.get_customer_by_id;

import br.com.standard.domain.entity.Customer;
import br.com.standard.domain.port.repository.CustomerRepository;

public class GetCustomerByIdQueryHandler {
    
    private final CustomerRepository repository;

    public GetCustomerByIdQueryHandler(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer handle(GetCustomerByIdQuery query) {
        return repository.findById(query.getId());
    }
}
