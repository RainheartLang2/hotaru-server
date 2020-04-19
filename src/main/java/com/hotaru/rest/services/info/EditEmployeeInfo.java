package com.hotaru.rest.services.info;

import com.hotaru.database.entities.Employee;
import com.hotaru.database.entities.Login;

public class EditEmployeeInfo {
    Employee employee;
    Login login;

    EditEmployeeInfo() {}

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}