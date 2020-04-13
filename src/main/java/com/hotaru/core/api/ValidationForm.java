package com.hotaru.core.api;

import com.hotaru.core.exceptions.ValidationException;

import java.util.Collection;

public abstract class ValidationForm<ObjectType> {
    public abstract void validate(ObjectType value) throws ValidationException;

    protected <ValueType> void validateField(ValueType value,
                                             Collection<Validator<ValueType>> validators) throws ValidationException {
        for (Validator<ValueType> validator: validators) {
            validator.validate(value);
        }
    }
}
