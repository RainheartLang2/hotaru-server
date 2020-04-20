package com.hotaru.rpc;

import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Employee;
import com.hotaru.database.entities.Login;

import java.util.List;

public interface EmployeeServiceBase {

    List<Employee> getAll();
    int add(Employee employee, Login login) throws ValidationException;
    void update(Employee employee, Login login) throws ValidationException;
    void delete(int id);
}
