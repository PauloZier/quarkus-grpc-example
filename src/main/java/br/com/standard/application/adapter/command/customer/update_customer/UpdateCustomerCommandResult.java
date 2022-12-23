package br.com.standard.application.adapter.command.customer.update_customer;

import br.com.standard.domain.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateCustomerCommandResult {
    
    private Long id;
    private String name;
    private String email;
    private String phone;

    public static UpdateCustomerCommandResult of(Customer customer) {
        return new UpdateCustomerCommandResult(customer.getId(), 
            customer.getName(), 
            customer.getEmail(), 
            customer.getPhone());
    }
}
