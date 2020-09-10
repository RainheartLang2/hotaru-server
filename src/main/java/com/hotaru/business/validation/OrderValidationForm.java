package com.hotaru.business.validation;

import com.hotaru.business.enums.DeliveryType;
import com.hotaru.core.api.ValidationForm;
import com.hotaru.core.api.validators.MaximalLengthValidator;
import com.hotaru.core.api.validators.OnlyDigitsValidator;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Order;

public class OrderValidationForm extends ValidationForm<Order> {
    public static OrderValidationForm INSTANCE = new OrderValidationForm();

    private OrderValidationForm() {}

    @Override
    public void validate(Order value) throws ValidationException {
        validateField(value.getName(), new MaximalLengthValidator("Поле 'имя' не может иметь длину болье 100", 100));
        validateField(value.getPhone(),
                new MaximalLengthValidator("", 15),
                new OnlyDigitsValidator("")
                );
        validateField(value.getAddress(), new MaximalLengthValidator("", 400));
        validateField(value.getAdditionalInfo(), new MaximalLengthValidator("", 4000));
        if (value.getDeliveryType() == DeliveryType.RegionDelivery && value.getLocalityId() == 0) {
            throw new ValidationException();
        }
    }
}
