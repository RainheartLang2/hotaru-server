package com.hotaru.database.resources;

import com.hotaru.core.database.ArchivableResourceBase;
import com.hotaru.database.entities.Employee;

public class EmployeeResource extends ArchivableResourceBase<Employee> {
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
