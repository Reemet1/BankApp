package com.prometheus.bank.form.validator;

import com.prometheus.bank.form.validator.constraint.TransactionAmountConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TransactionAmountValidator implements ConstraintValidator<TransactionAmountConstraint, Double> {

    @Override
    public void initialize(TransactionAmountConstraint transactionAmountConstraint) {
    }

    @Override
    public boolean isValid(Double transactionAmount, ConstraintValidatorContext cxt) {

        return transactionAmount > 0;
    }

}

