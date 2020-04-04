package com.hotaru.rest.services;

import com.hotaru.database.entities.Employee;
import com.hotaru.database.resources.EmployeeResource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/employees")
public class EmployeesService {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getAll() {
        return EmployeeResource.getInstance().getAll();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(Employee employee) {
        EmployeeResource.getInstance().saveOrUpdate(employee);
    }
}
