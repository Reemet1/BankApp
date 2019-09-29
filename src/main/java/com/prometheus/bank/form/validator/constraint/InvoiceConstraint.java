package com.prometheus.bank.form.validator.constraint;

import com.prometheus.bank.form.validator.InvoiceValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = InvoiceValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface InvoiceConstraint {
    String message() default "Invalid invoice";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
