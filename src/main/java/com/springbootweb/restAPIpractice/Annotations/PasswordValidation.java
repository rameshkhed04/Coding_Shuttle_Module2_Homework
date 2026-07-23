package com.springbootweb.restAPIpractice.Annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidation implements ConstraintValidator<passwordvalidater,String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        int length = s.length();

        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);

            if (Character.isUpperCase(ch)){
                hasUpperCase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowerCase = true;

            }else if (Character.isDigit(ch)){
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecialChar = true;
            }

            if(hasDigit && hasUpperCase && hasLowerCase && hasSpecialChar && length >10){
                return true;

            }

        }
        return false;
    }
}
