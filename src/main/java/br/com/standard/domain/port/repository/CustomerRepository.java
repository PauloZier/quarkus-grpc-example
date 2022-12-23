package br.com.standard.domain.port.repository;

import java.util.List;

import br.com.standard.domain.entity.Customer;

public interface CustomerRepository {
    Customer save(Customer customer);
    Customer findById(Long id);
    List<Customer> findAll();
    void delete(Long id);
}
