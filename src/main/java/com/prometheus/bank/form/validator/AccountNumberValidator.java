package com.prometheus.bank.form.validator;

import com.prometheus.bank.form.validator.constraint.AccountNumberConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AccountNumberValidator implements ConstraintValidator<AccountNumberConstraint, String> {

    private String regex;

    @Override
    public void initialize(AccountNumberConstraint accountNumberConstraint) {
        regex = accountNumberConstraint.regex();
    }

    @Override
    public boolean isValid(String accountNumber, ConstraintValidatorContext cxt) {

        return accountNumber.matches(regex);
    }

}
