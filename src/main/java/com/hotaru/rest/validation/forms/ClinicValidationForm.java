package com.hotaru.rest.validation.forms;

import com.hotaru.core.api.ValidationForm;
import com.hotaru.core.api.validators.*;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Clinic;

import java.util.List;

public class ClinicValidationForm extends ValidationForm<Clinic> {

    public static ClinicValidationForm INSTANCE = new ClinicValidationForm();

    private ClinicValidationForm() {
    }

    @Override
    public void validate(Clinic clinic) throws ValidationException {
        validateField(clinic.getName(),
                new RequiredFieldStringValidator("Field 'name' not allowed to be empty"),
                        new MaximalLengthValidator("Field 'name' not allowed to be longer than 200 character", 200)
        );

        validateField(clinic.getPhone(), new PhoneValidator());

        validateField(clinic.getEmail(), new EmailValidator());

        validateField(clinic.getAddress(),
                new MaximalLengthValidator("Field 'address' not allowed to be longer than 2048 characters", 2048));

        validateField(clinic.getSiteUrl(),
                new MaximalLengthValidator("Field 'siteUrl' not allowed to be longer than 256 characters", 256));
    }
}
