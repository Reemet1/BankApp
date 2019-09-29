package com.prometheus.bank.form.validator.constraint;

import com.prometheus.bank.form.validator.TransactionAmountValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TransactionAmountValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TransactionAmountConstraint {
    String message() default "Invalid transaction amount";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
