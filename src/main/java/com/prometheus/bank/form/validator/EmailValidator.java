package com.prometheus.bank.form.validator;

import com.prometheus.bank.form.validator.constraint.EmailConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {

    private String regex;

    @Override
    public void initialize(EmailConstraint emailConstraint) {
        regex = emailConstraint.regex();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext cxt) {

        return email.matches(regex);
    }

}
