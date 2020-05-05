package com.hotaru.core.api.validators;

import com.hotaru.core.api.Validator;
import com.hotaru.core.entities.DateRange;

public class DateRangeConsistencyValidator extends Validator<DateRange> {
    public DateRangeConsistencyValidator(String message) {
        super(message);
    }

    @Override
    protected boolean innerValidate(DateRange dateRange) {
        return dateRange.getStartDate().before(dateRange.getEndDate());
    }
}
