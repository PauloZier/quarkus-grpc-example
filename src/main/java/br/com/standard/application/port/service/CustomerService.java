package br.com.standard.application.port.service;

import java.util.List;

import br.com.standard.application.adapter.command.customer.create_customer.CreateCustomerCommand;
import br.com.standard.application.adapter.command.customer.create_customer.CreateCustomerCommandResult;
import br.com.standard.application.adapter.command.customer.delete_customer.DeleteCustomerCommand;
import br.com.standard.application.adapter.command.customer.update_customer.UpdateCustomerCommand;
import br.com.standard.application.adapter.command.customer.update_customer.UpdateCustomerCommandResult;
import br.com.standard.application.adapter.query.customer.get_customer_by_id.GetCustomerByIdQuery;
import br.com.standard.application.adapter.query.customer.get_customers.GetCustomersQuery;
import br.com.standard.domain.entity.Customer;

public interface CustomerService {
    CreateCustomerCommandResult send(CreateCustomerCommand command);
    UpdateCustomerCommandResult send(UpdateCustomerCommand command);
    void send(DeleteCustomerCommand command);
    List<Customer> query(GetCustomersQuery query);
    Customer query(GetCustomerByIdQuery query);
}
