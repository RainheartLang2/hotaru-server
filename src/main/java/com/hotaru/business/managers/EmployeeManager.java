package com.hotaru.business.managers;

import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Employee;
import com.hotaru.database.entities.Login;
import com.hotaru.database.resources.EmployeeResource;
import com.hotaru.database.resources.LoginResource;

public class EmployeeManager {
    private static EmployeeManager INSTANCE = new EmployeeManager();

    public static EmployeeManager getInstance() {
        return INSTANCE;
    }

    public EmployeeManager() {}

    public int addEmployee(Employee employee, Login login) throws ValidationException {
        EmployeeResource.getInstance().saveOrUpdate(employee);
        int employeeId = employee.getId();
        login.setUserId(employeeId);
        LoginResource.getInstance().saveOrUpdate(login);
        return employeeId;
    }
}
