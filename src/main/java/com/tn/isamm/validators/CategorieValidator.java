package com.tn.isamm.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.tn.isamm.entities.Categorie;



public class CategorieValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Categorie.class.equals(clazz);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		
	}

}
