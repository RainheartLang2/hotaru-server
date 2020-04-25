package com.hotaru.rest.validation.forms;

import com.hotaru.core.api.ValidationForm;
import com.hotaru.core.api.validators.*;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Employee;

import java.util.List;

public class EmployeeValidationForm extends ValidationForm<Employee> {

    public static EmployeeValidationForm INSTANCE = new EmployeeValidationForm();

    private EmployeeValidationForm() {
    }

    @Override
    public void validate(Employee employee) throws ValidationException {
        validateField(employee.getFirstName(),
                new RequiredFieldStringValidator("Field 'firstName' not allowed to be empty"),
                        new MaximalLengthValidator("Field 'firstName' not allowed to be longer than 100 characters", 100)
        );

        validateField(employee.getMiddleName(),
                new MaximalLengthValidator("Field 'middleName' not allowed to be longer than 100 characters", 100)
        );

        validateField(employee.getLastName(),
                new RequiredFieldStringValidator("Field 'lastName' not allowed to be empty"),
                        new MaximalLengthValidator("Field 'lastName' not allowed to be longer than 100 characters", 100)
        );

        validateField(employee.getPhone(), new PhoneValidator());

        validateField(employee.getEmail(), new EmailValidator());

        validateField(employee.getAddress(),
                new MaximalLengthValidator("Field 'address' not allowed to be longer than 2048 characters", 2048));
    }
}
