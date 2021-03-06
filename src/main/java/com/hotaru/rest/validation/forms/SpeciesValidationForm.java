package com.hotaru.rest.validation.forms;

import com.hotaru.core.api.ValidationForm;
import com.hotaru.core.api.validators.MaximalLengthValidator;
import com.hotaru.core.api.validators.RequiredFieldStringValidator;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Species;

public class SpeciesValidationForm extends ValidationForm<Species> {

    public static SpeciesValidationForm INSTANCE = new SpeciesValidationForm();

    private SpeciesValidationForm() {
    }

    @Override
    public void validate(Species value) throws ValidationException {
        validateField(value.getName(),
                new RequiredFieldStringValidator("Field 'name' not allowed to be empty"),
                new MaximalLengthValidator("Field 'name' not allowed to be longer than 100 characters", 200)
        );
    }
}
