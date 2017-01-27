package com.example.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.repository.UserDao;

public class UniqueUserNameVImple implements ConstraintValidator<UniqueUserName, String> {

	@Autowired
    private UserDao userDao;

	
	@Override
	public void initialize(UniqueUserName constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		if(userDao==null){
			return true;
		}
		return userDao.findByName(username)==null;
	}

}
