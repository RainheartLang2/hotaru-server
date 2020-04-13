package com.hotaru.rest.services;

import com.hotaru.database.entities.Employee;
import com.hotaru.database.resources.EmployeeResource;

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
    public int add(Employee employee) {
        EmployeeResource.getInstance().saveOrUpdate(employee);
        return employee.getId();
    }

    @POST
    @Path("/edit")
    public boolean updateEmployee(Employee employee) {
        EmployeeResource resource = EmployeeResource.getInstance();
        Employee updatedEmployee = resource.getById(employee.getId());
        updatedEmployee.merge(employee);
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
