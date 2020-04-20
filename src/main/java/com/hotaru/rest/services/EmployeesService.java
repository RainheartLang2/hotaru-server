package com.hotaru.rest.services;

import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Employee;
import com.hotaru.database.entities.Login;
import com.hotaru.database.resources.EmployeeResource;
import com.hotaru.database.resources.LoginResource;
import com.hotaru.rest.services.info.EditEmployeeInfo;
import com.hotaru.rest.validation.forms.EmployeeValidationForm;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;

@Path("/employees")
@Produces("application/json; charset=UTF-8")
@Consumes("application/json; charset=UTF-8")
public class EmployeesService {

    @GET
    @Path("/all")
    public List<Employee> getAll(@Context HttpServletRequest request) {
        return EmployeeResource.getInstance().getAllNotDeleted();
    }

    @POST
    @Path("/add")
    public int add(EditEmployeeInfo info) throws ValidationException {
        Employee employee = info.getEmployee();
        Login login = info.getLogin();

        EmployeeValidationForm.INSTANCE.validate(employee);
        EmployeeResource.getInstance().saveOrUpdate(employee);
        int employeeId = employee.getId();
        login.setUserId(employeeId);
        LoginResource.getInstance().saveOrUpdate(login);
        return employee.getId();
    }

    @POST
    @Path("/edit")
    public boolean updateEmployee(EditEmployeeInfo info) throws ValidationException {
        Employee employee = info.getEmployee();
        Login login = info.getLogin();

        EmployeeResource resource = EmployeeResource.getInstance();
        Employee updatedEmployee = resource.getById(employee.getId());
        updatedEmployee.merge(employee);
        EmployeeValidationForm.INSTANCE.validate(updatedEmployee);
        resource.saveOrUpdate(updatedEmployee);
        if (login != null) {
            login.setUserId(employee.getId());
            LoginResource.getInstance().saveOrUpdate(login);
        }
        return true;
    }

    @DELETE
    @Path("/delete")
    public boolean delete(@QueryParam("id") int id) {
        EmployeeResource.getInstance().markDeleted(id);
        return true;
    }
}
