package com.hotaru.core.api.validators;

import com.hotaru.core.api.Validator;

public class RequiredFieldStringValidator extends Validator<String> {

    public RequiredFieldStringValidator(String message) {
        super(message);
    }

    @Override
    protected boolean innerValidate(String value) {
        return value != null && value.length() > 0;
    }
}
