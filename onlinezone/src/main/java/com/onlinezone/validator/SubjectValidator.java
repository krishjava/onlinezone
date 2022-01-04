package com.onlinezone.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SubjectValidator implements ConstraintValidator<SubjectCode, Integer> {
	
	private int maxDigit;
	private int minDigit;
	
	public void initialize(SubjectCode code) {
		this.minDigit=code.minDigit();
		this.maxDigit=code.maxDigit();
	}
	
	public boolean isValid(Integer codeValue, ConstraintValidatorContext context) {
		if(codeValue==null) {
			return false;
		}if(codeValue<minDigit || codeValue>maxDigit) {
			return false;
		}
		return true;
	}

}
