package br.com.standard.application.adapter.command.customer.update_customer;

import javax.annotation.Nullable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import br.com.standard.domain.port.command.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateCustomerCommand implements Command {
    
    @NotNull
    private Long id;

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
