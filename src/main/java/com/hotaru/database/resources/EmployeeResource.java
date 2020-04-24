package com.hotaru.database.resources;

import com.hotaru.core.database.ArchivableResourceBase;
import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.Employee;
import org.hibernate.criterion.Restrictions;

import java.util.List;

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
