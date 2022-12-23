package br.com.standard.application.adapter.command.customer.create_customer;

import javax.annotation.Nullable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.standard.domain.port.command.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateCustomerCommand implements Command {
    
    @NotBlank
    @Length(min = 2, max = 255)
    private String name;

    @Email
    @NotBlank
    @Length(max = 255)
    private String email;

    @Nullable
    @Length(min = 0, max = 25)
    private String phone;
}
