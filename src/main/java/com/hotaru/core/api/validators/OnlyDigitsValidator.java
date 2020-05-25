package com.hotaru.core.api.validators;

import com.hotaru.core.api.Validator;

public class OnlyDigitsValidator extends Validator<String> {

    public OnlyDigitsValidator(String message) {
        super(message);
    }

    private static String pattern = "^\\d*$";
    @Override
    protected boolean innerValidate(String value) {
        return value == null || value.matches(pattern);
    }
}
