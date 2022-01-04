package com.onlinezone.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlinezone.front.dao.UserDao;

public class CheckUniqueEmailConstraint implements ConstraintValidator<CheckUniqueEmail, String> {

	@Autowired
	UserDao userDao;
	
	public boolean isValid(String email, ConstraintValidatorContext context) {
		System.out.println("isValid : "+email);
		String cmail=userDao.getUserEmail(email);
		System.out.println(cmail);
		return cmail.equals("none");
	}

}
