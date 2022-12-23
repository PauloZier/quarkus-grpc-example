package br.com.standard.application.adapter.query.customer.get_customer_by_id;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetCustomerByIdQuery {
    @NotNull
    private Long id;
}