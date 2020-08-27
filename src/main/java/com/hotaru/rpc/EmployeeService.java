package com.hotaru.rpc;

import com.googlecode.jsonrpc4j.JsonRpcMethod;
import com.hotaru.business.managers.EmployeeManager;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Employee;
import com.hotaru.database.entities.Login;
import com.hotaru.database.resources.EmployeeResource;
import com.hotaru.database.resources.LoginResource;

import java.util.List;

public class EmployeeService implements EmployeeServiceBase {

    @JsonRpcMethod("EmployeeService.getAll")
    public List<Employee> getAll() {
        return EmployeeResource.getInstance().getAll();
    }

    public int add(Employee employee, Login login) throws ValidationException {
        return EmployeeManager.getInstance().addEmployee(employee, login);
    }

    public void update(Employee employee, Login login) throws ValidationException {
        EmployeeResource resource = EmployeeResource.getInstance();
        Employee updatedEmployee = resource.getById(employee.getId());
        resource.saveOrUpdate(updatedEmployee);
        if (login != null) {
            login.setUserId(employee.getId());
            LoginResource.getInstance().saveOrUpdate(login);
        }
    }

    public void delete(int id) {
        EmployeeResource.getInstance().delete(id);
    }
}
