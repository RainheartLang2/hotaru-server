package com.hotaru.business.validation;

import com.hotaru.core.api.ValidationForm;
import com.hotaru.core.api.validators.MaximalLengthValidator;
import com.hotaru.core.api.validators.MaximalNumberValidator;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Locality;

public class LocalityValidationForm extends ValidationForm<Locality> {

    public static final LocalityValidationForm INSTANCE = new LocalityValidationForm();

    private LocalityValidationForm() {}
    @Override
    public void validate(Locality value) throws ValidationException {
        validateField(value.getName(), new MaximalLengthValidator("Поле 'имя' не может иметь длину болье 100", 100));
        validateField(value.getDistance(), new MaximalNumberValidator(99999));
    }
}
