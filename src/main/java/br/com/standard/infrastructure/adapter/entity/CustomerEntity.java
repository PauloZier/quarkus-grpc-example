package br.com.standard.infrastructure.adapter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.standard.domain.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customer")
public class CustomerEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 255, nullable = false)
    private String name;
    
    @Column(length = 255, nullable = false, unique = true)
    private String email;
    
    @Column(length = 25, nullable = true)
    private String phone;

    public CustomerEntity(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.phone = customer.getPhone();
    }

    public Customer toCustomer() {
        return new Customer(this.id, this.name, this.email, this.phone);
    }
}
