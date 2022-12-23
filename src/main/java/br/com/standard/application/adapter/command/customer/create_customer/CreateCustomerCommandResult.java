package br.com.standard.application.adapter.command.customer.create_customer;

import br.com.standard.domain.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateCustomerCommandResult {
    
    private Long id;
    private String name;
    private String email;
    private String phone;

    public static CreateCustomerCommandResult of(Customer customer) {
        return new CreateCustomerCommandResult(customer.getId(), 
            customer.getName(), 
            customer.getEmail(), 
            customer.getPhone());
    }
}
