package br.com.standard.application.adapter.service;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

public abstract class ServiceBase {
    
    protected final Validator validator;

    protected ServiceBase(Validator validator) {
        this.validator = validator;
    }

    protected <T> void validate(T t) {
        var validations = validator.validate(t);
        if (!validations.isEmpty())
            throw new ConstraintViolationException(validations);
    }
}
