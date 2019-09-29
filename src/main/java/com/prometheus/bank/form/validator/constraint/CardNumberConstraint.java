package com.prometheus.bank.form.validator.constraint;

import com.prometheus.bank.form.validator.CardNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CardNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CardNumberConstraint {
    String message() default "Invalid card number";
    String regex() default "[0-9]{16}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
