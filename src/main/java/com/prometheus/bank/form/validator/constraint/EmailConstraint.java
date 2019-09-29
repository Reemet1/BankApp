package com.prometheus.bank.form.validator.constraint;

import com.prometheus.bank.form.validator.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailConstraint {
    String message() default "Invalid email";
    String regex() default ".*@gmail.com";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
