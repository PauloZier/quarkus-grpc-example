package br.com.standard.infrastructure.adapter.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;

import br.com.standard.domain.entity.Customer;
import br.com.standard.domain.port.repository.CustomerRepository;
import br.com.standard.infrastructure.adapter.entity.CustomerEntity;

@RequestScoped
public class CustomerRepositoryImpl implements CustomerRepository {

    private final PanacheCustomerRepository repository;

    public CustomerRepositoryImpl(PanacheCustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer save(Customer customer) {
        var entity = new CustomerEntity(customer);
        
        if (entity.getId() == null)
            this.repository.persistAndFlush(entity);
        else {
            var entityManager = this.repository.getEntityManager();
            entityManager.merge(entity);
            entityManager.flush();
        }

        return entity.toCustomer();
    }

    @Override
    public Customer findById(Long id) {
        return this.repository
            .findById(id)
            .toCustomer();
    }

    @Override
    public List<Customer> findAll() {
        return this.repository
            .listAll()
            .stream()
            .map(CustomerEntity::toCustomer)
            .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }   
}
