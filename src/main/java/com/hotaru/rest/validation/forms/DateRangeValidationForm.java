package com.hotaru.rest.validation.forms;

import com.hotaru.core.api.ValidationForm;
import com.hotaru.core.api.validators.DateRangeConsistencyValidator;
import com.hotaru.core.api.validators.DateRangeRequiredValidator;
import com.hotaru.core.entities.DateRange;
import com.hotaru.core.exceptions.ValidationException;

public class DateRangeValidationForm extends ValidationForm<DateRange> {

    public static DateRangeValidationForm INSTANCE = new DateRangeValidationForm();

    private DateRangeValidationForm() { }

    @Override
    public void validate(DateRange dateRange) throws ValidationException {
        validateField(dateRange,
                new DateRangeRequiredValidator("Fields 'startDate' and 'endDate' should not be null"),
                new DateRangeConsistencyValidator("'startDate' should be after 'endDate'")
        );
    }
}
