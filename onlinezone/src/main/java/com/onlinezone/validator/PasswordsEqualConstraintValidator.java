package com.onlinezone.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.onlinezone.front.model.User;

public class PasswordsEqualConstraintValidator implements ConstraintValidator<PasswordsEqualConstraint, Object> {

	public boolean isValid(Object user, ConstraintValidatorContext context) {
		User umodel= (User) user;
		return umodel.getPassword().equals(umodel.getCpassword());
	}

}
