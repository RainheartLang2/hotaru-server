package com.hotaru.core.api.validators;

import com.hotaru.core.api.Validator;

public class MaximalNumberValidator extends Validator<Integer> {
    private int maxValue;

    public MaximalNumberValidator(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    protected boolean innerValidate(Integer value) {
        return value <= this.maxValue;
    }
}
