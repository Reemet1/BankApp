package com.prometheus.bank.form.validator.constraint;

import com.prometheus.bank.form.validator.StartingBalanceValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StartingBalanceValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface StartingBalanceConstraint {
    String message() default "Invalid starting balance";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
