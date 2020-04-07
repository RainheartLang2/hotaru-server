package com.hotaru.database.resources;

import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.Employee;
import org.hibernate.criterion.Restrictions;

import java.util.List;

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

    public List<Employee> getAllNotDeleted() {
        return getSession()
                .createCriteria(Employee.class)
                .add(Restrictions.eq("deleted", false))
                .list();
    }

    public void markDeleted(int id) {
        Employee employee = this.getById(id);
        employee.setDeleted(true);
        getSession().delete(employee);
    }
}
