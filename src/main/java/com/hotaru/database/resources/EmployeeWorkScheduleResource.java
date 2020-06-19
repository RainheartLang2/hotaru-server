package com.hotaru.database.resources;

import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.EmployeeWorkSchedule;
import org.hibernate.criterion.Restrictions;

public class EmployeeWorkScheduleResource extends ResourceBase<EmployeeWorkSchedule> {
    private static EmployeeWorkScheduleResource INSTANCE = new EmployeeWorkScheduleResource();

    public static EmployeeWorkScheduleResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EmployeeWorkScheduleResource();
        }
        return INSTANCE;
    }

    public EmployeeWorkSchedule getByEmployeeId(int employeeId) {
        return (EmployeeWorkSchedule) getSession().
                createCriteria(EmployeeWorkSchedule.class)
                .add(Restrictions.in("employeeId", employeeId))
                .uniqueResult();
    }

    public EmployeeWorkSchedule getDefaultSchedule() {
        return (EmployeeWorkSchedule) getSession()
                .createCriteria(EmployeeWorkSchedule.class)
                .add(Restrictions.eq("defaultSchedule", true))
                .uniqueResult();
    }

    private EmployeeWorkScheduleResource() {
        super();
    }
}
