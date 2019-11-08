package com.jkc.SecurityApp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

	private String firstFieldName;
	private String secondFieldName;
	private String message;

	@Override
	public void initialize(FieldMatch constraintAnnotation) {
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(Object arg0, ConstraintValidatorContext arg1) {
		boolean valid = true;
		try {
			final Object firstObject = new BeanWrapperImpl(arg0).getPropertyValue(firstFieldName);
			final Object secondObject = new BeanWrapperImpl(arg0).getPropertyValue(secondFieldName);
			valid = (firstObject == null && secondObject == null)
					|| (firstObject != null && firstObject.equals(secondObject));
		} catch (Exception e) {
			System.out.println("Got a Exception While Validating -----~~~~~~))))))");
		}
		if (!valid) {
			arg1.buildConstraintViolationWithTemplate(message).addPropertyNode(firstFieldName).addConstraintViolation()
					.disableDefaultConstraintViolation();
		}
		return valid;
	}

}
