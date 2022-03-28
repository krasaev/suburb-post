package com.krasaev.suburbpost.postcode.validation;

import com.krasaev.suburbpost.postcode.validation.constraint.PostcodeConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = PostcodeConstraint.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Postcode {

    String message() default "Invalid postcode";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
