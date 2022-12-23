package br.com.standard.application.adapter.command.customer.delete_customer;

import javax.validation.constraints.NotNull;
import br.com.standard.domain.port.command.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteCustomerCommand implements Command {
    
    @NotNull
    private Long id;
}
