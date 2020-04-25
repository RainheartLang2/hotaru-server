package com.hotaru.core.api.validators;

import com.hotaru.core.api.Validator;

import java.util.List;

public class EmailValidator extends CompositeValidator<String> {
    public EmailValidator() {
        super(List.of(new MaximalLengthValidator("Field 'email' not allowed to be longer than 254 characters", 254),
                new EmailAddressFormatValidator("Field 'email' must be in format of 'a@b'")));
    }
}
