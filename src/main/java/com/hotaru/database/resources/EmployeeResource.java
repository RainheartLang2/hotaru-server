package com.hotaru.database.resources;

import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.Employee;

public class EmployeeResource extends ResourceBase<Employee> {
    private static EmployeeResource INSTANCE = new EmployeeResource();

    public static EmployeeResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EmployeeResource();
        }
        return INSTANCE;
    }

    private EmployeeResource() {
        super();
    }
}
