package com.hotaru.rest.services;

import com.hotaru.database.entities.Employee;
import com.hotaru.database.resources.EmployeeResource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/employees")
@Produces("application/json; charset=UTF-8")
@Consumes("application/json; charset=UTF-8")
public class EmployeesService {

    @GET
    @Path("/all")
    public List<Employee> getAll() {
        return EmployeeResource.getInstance().getAll();
    }

    @POST
    @Path("/add")
    public void add(Employee employee) {
        EmployeeResource.getInstance().saveOrUpdate(employee);
    }
}
