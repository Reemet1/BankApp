package com.prometheus.bank.form.validator.constraint;

import com.prometheus.bank.form.validator.AccountNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AccountNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AccountNumberConstraint {
    String message() default "Invalid account number";
    String regex() default "EE2050[0-9]{14}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
