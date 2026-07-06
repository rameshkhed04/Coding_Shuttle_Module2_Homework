package com.springbootweb.restAPIpractice.Annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class checkPrimeValidater implements ConstraintValidator<PrimeValidation,Long> {
    @Override
    public boolean isValid(Long num, ConstraintValidatorContext constraintValidatorContext) {

        if(num<=1) return false;

        if (num ==2) return true;

        if (num %2 ==0) return false;

        for(int i=3;i<= Math.sqrt(num);i+=2){
            if(num % i ==0){
                return false;

            }
            break;
        }


        return  true;

    }
}
