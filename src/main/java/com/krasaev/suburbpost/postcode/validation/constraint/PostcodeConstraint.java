package com.krasaev.suburbpost.postcode.validation.constraint;

import com.krasaev.suburbpost.postcode.validation.Postcode;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PostcodeConstraint implements ConstraintValidator<Postcode, String> {

    public static final int POSTCODE_LENGTH = 4;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String postcode = StringUtils.defaultString(value);
        return postcode.length() == POSTCODE_LENGTH && postcode.chars().allMatch(Character::isDigit);
    }
}
