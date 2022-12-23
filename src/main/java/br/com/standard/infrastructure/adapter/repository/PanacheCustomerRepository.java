package br.com.standard.infrastructure.adapter.repository;

import javax.enterprise.context.RequestScoped;

import br.com.standard.infrastructure.adapter.entity.CustomerEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@RequestScoped
public class PanacheCustomerRepository implements PanacheRepository<CustomerEntity> {
    
}
