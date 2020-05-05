package com.hotaru.rest.validation.forms;

import com.hotaru.core.api.ValidationForm;
import com.hotaru.core.api.validators.DateRangeConsistencyValidator;
import com.hotaru.core.api.validators.DateRangeRequiredValidator;
import com.hotaru.core.api.validators.MaximalLengthValidator;
import com.hotaru.core.api.validators.RequiredFieldStringValidator;
import com.hotaru.core.entities.DateRange;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Appointment;

public class AppointmentValidationForm extends ValidationForm<Appointment> {

    public static AppointmentValidationForm INSTANCE = new AppointmentValidationForm();

    private AppointmentValidationForm() { }

    @Override
    public void validate(Appointment appointment) throws ValidationException {
        validateField(appointment.getTitle(),
                new RequiredFieldStringValidator("Field 'title' not allowed to be empty"),
                new MaximalLengthValidator("Field 'title' not allowed to be longer than 100 character", 100)
        );

        DateRangeValidationForm.INSTANCE.validate(new DateRange(appointment.getStartDate(), appointment.getEndDate()));
    }
}
