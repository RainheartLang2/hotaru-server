package com.hotaru.rest.services;

import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Employee;
import com.hotaru.database.resources.EmployeeResource;
import com.hotaru.rest.validation.forms.EmployeeValidationForm;

import javax.ws.rs.*;
import java.util.List;

@Path("/employees")
@Produces("application/json; charset=UTF-8")
@Consumes("application/json; charset=UTF-8")
public class EmployeesService {

    @GET
    @Path("/all")
    public List<Employee> getAll() {
        return EmployeeResource.getInstance().getAllNotDeleted();
    }

    @POST
    @Path("/add")
    public int add(Employee employee) throws ValidationException {
        EmployeeValidationForm.INSTANCE.validate(employee);
        EmployeeResource.getInstance().saveOrUpdate(employee);
        return employee.getId();
    }

    @POST
    @Path("/edit")
    public boolean updateEmployee(Employee employee) throws ValidationException {
        EmployeeResource resource = EmployeeResource.getInstance();
        Employee updatedEmployee = resource.getById(employee.getId());
        updatedEmployee.merge(employee);
        EmployeeValidationForm.INSTANCE.validate(updatedEmployee);
        resource.saveOrUpdate(updatedEmployee);
        return true;
    }

    @DELETE
    @Path("/delete")
    public boolean delete(@QueryParam("id") int id) {
        EmployeeResource.getInstance().delete(id);
        return true;
    }
}
