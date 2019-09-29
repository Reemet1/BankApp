package com.prometheus.bank.form.validator;

import com.prometheus.bank.form.validator.constraint.CardNumberConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CardNumberValidator implements ConstraintValidator<CardNumberConstraint, String> {


    @Override
    public void initialize(CardNumberConstraint cardNumberConstraint) {

    }

    @Override
    public boolean isValid(String cardNumber, ConstraintValidatorContext cxt) {

        return cardNumber.matches("[0-9]{6}");
    }

}
