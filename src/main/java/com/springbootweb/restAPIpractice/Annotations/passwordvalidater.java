package com.springbootweb.restAPIpractice.Annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PasswordValidation.class})
public @interface passwordvalidater {
    String message() default "{The password must contains one uppercase letter\n" +
            "contains one lowercase letter\n" +
            "contains one special character\n" +
            "and minimum length is 10 characters}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
