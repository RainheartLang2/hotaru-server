package com.hotaru.core.api.validators;

import com.hotaru.core.api.Validator;
import com.hotaru.core.exceptions.ValidationException;

import java.util.List;

public class CompositeValidator<ValueType> extends Validator<ValueType> {
    private List<Validator<ValueType>> validators;

    public CompositeValidator(List<Validator<ValueType>> validators) {
        this.validators = validators;
    }

    @Override
    public void validate(ValueType value) throws ValidationException {
        for (Validator<ValueType> validator: validators) {
            validator.validate(value);
        }
    }

    @Override
    protected boolean innerValidate(ValueType value) {
        throw new UnsupportedOperationException();
    }
}
