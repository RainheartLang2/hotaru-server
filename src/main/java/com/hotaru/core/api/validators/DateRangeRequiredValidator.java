package com.hotaru.core.api.validators;

import com.hotaru.core.api.Validator;
import com.hotaru.core.entities.DateRange;

public class DateRangeRequiredValidator extends Validator<DateRange> {
    public DateRangeRequiredValidator(String message) {
        super(message);
    }

    @Override
    protected boolean innerValidate(DateRange dateRange) {
        return dateRange.getStartDate() != null && dateRange.getEndDate() != null;
    }
}
