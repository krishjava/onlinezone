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
@Constraint(validatedBy = SubjectValidator.class)
public @interface SubjectCode {

	String message() default "{invalidCodeMessage}";
	
	int minDigit() default 100 ;
	int maxDigit() default 900 ;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
