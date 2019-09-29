package com.prometheus.bank.form.validator.constraint;

import com.prometheus.bank.form.validator.NameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NameValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NameConstraint {
    String message() default "Invalid name";
    String regex() default "[a-zA-Z-]+";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
