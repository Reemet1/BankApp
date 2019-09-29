package com.prometheus.bank.form.validator;

import com.prometheus.bank.form.validator.constraint.NameConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<NameConstraint, String> {

    private String regex;

    @Override
    public void initialize(NameConstraint nameConstraint) {
        regex = nameConstraint.regex();
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext cxt) {
        return name.matches(regex);
    }

}

