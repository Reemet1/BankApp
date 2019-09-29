package com.prometheus.bank.form.validator;

import com.prometheus.bank.form.validator.constraint.StartingBalanceConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartingBalanceValidator implements ConstraintValidator<StartingBalanceConstraint, Double> {

    @Override
    public void initialize(StartingBalanceConstraint startingBalanceConstraint) {
    }

    @Override
    public boolean isValid(Double startingBalance, ConstraintValidatorContext cxt) {

        return startingBalance > 0;
    }

}

