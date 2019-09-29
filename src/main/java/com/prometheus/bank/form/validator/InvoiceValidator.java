package com.prometheus.bank.form.validator;

import com.prometheus.bank.form.validator.constraint.InvoiceConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InvoiceValidator implements ConstraintValidator<InvoiceConstraint, Long> {

    @Override
    public void initialize(InvoiceConstraint invoiceConstraint) {
    }

    @Override
    public boolean isValid(Long invoice, ConstraintValidatorContext cxt) {

        return Long.toString(invoice).matches("[0-9]{6}");
    }

}
