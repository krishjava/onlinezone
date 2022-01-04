package com.onlinezone.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = CheckUniqueEmailConstraint.class)
public @interface CheckUniqueEmail {
	String message() default "{invalidEmailMessage}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
