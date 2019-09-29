package com.prometheus.bank.form.validator;

import com.prometheus.bank.form.validator.constraint.UsernameConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<UsernameConstraint, String> {

    @Override
    public void initialize(UsernameConstraint usernameConstraint) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext cxt) {

        return username.matches("[0-9]{6}");
    }

}

