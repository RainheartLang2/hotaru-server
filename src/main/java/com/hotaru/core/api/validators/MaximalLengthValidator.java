package com.hotaru.core.api.validators;

import com.hotaru.core.api.Validator;

public class MaximalLengthValidator extends Validator<String> {
    private int length;

    public MaximalLengthValidator(String message, int length) {
        super(message);
        this.length = length;
    }

    @Override
    protected boolean innerValidate(String value) {
        return value.length() <= this.length;
    }
}
