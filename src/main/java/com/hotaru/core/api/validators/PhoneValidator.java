package com.hotaru.core.api.validators;

import java.util.List;

public class PhoneValidator extends CompositeValidator<String> {
    public PhoneValidator() {
        super(List.of(new MaximalLengthValidator("Field 'phone' not allowed to be longer than 15 characters", 15),
                new OnlyDigitsValidator("Field 'phone' allowed to contain only digit characters")
        ));
    }
}
