package com.tn.isamm.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.tn.isamm.entities.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
	
		
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		User  u = (User) obj;
		if (u.getUsername().length() <4)
		{
			errors.rejectValue("username", "user.username", "too short");
			
			
		}
			
		
		

	}

}
