package com.prometheus.bank.form.validator;

import com.prometheus.bank.form.validator.constraint.PasswordConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {

    @Override
    public void initialize(PasswordConstraint passwordConstraint) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext cxt) {

        return password.matches("[0-9]{6}");
    }

}
