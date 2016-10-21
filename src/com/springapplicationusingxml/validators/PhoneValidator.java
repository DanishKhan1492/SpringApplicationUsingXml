package com.springapplicationusingxml.validators;

import org.apache.log4j.Logger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by muhammadkhan on 10/1/16.
 */
public class PhoneValidator implements ConstraintValidator<Phone,String> {

    private static final Logger logger = Logger.getLogger(PhoneValidator.class);

    @Override
    public void initialize(Phone phone) {

    }

    @Override
    public boolean isValid(String phoneNo, ConstraintValidatorContext cvc) {
        logger.info("Verifying Phone Number");

        if(phoneNo.equals("") || phoneNo == null) {
            return false;
        } else if(phoneNo.matches("\\d{10}")){
            return  true;
        }
        logger.info("Phone Number not verified so there are some errors");
        return false;
    }
}
