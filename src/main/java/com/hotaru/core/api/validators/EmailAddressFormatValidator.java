package com.hotaru.core.api.validators;

import com.hotaru.core.api.Validator;

public class EmailAddressFormatValidator extends Validator<String> {
    public EmailAddressFormatValidator(String message) {
        super(message);
    }

    @Override
    protected boolean innerValidate(String value) {
        return value == null || value.length() == 0 || value.contains("@");
    }
}
