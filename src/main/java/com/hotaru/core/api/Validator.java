package com.hotaru.core.api;

import com.hotaru.core.exceptions.ValidationException;

public abstract class Validator<ValueType> {
    protected String message;

    protected Validator() {};

    public Validator(String message) {
        this.message = message;
    }

    public void validate(ValueType value) throws ValidationException {
        if (!innerValidate(value)) {
            throw new ValidationException(this.message);
        }
    }

    protected abstract boolean innerValidate(ValueType value);
}
