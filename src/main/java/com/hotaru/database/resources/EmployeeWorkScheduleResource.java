package com.hotaru.database.resources;

import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.EmployeeWorkSchedule;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.List;

public class EmployeeWorkScheduleResource extends ResourceBase<EmployeeWorkSchedule> {
    private static EmployeeWorkScheduleResource INSTANCE = new EmployeeWorkScheduleResource();

    public static EmployeeWorkScheduleResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EmployeeWorkScheduleResource();
        }
        return INSTANCE;
    }

    public EmployeeWorkSchedule getActualByEmployeeId(int employeeId) {
        return (EmployeeWorkSchedule) getSession()
                .createCriteria(EmployeeWorkSchedule.class)
                .add(Restrictions.in("employeeId", employeeId))
                .add(Restrictions.isNull("endDate"))
                .uniqueResult();
    }

    public List<EmployeeWorkSchedule> getScheduleForDateRange(int employeeId, Date startDate, Date endDate) {
        return getSession()
                .createCriteria(EmployeeWorkSchedule.class)
                .add(Restrictions.or(Restrictions.eq("employeeId", employeeId), Restrictions.eq("defaultSchedule", true)))
                .add(Restrictions.or(
                        Restrictions.and(Restrictions.isNull("endDate"), Restrictions.le("startDate", endDate)),
                        Restrictions.and(Restrictions.ge("startDate", startDate), Restrictions.le("startDate", endDate)),
                        Restrictions.and(Restrictions.ge("endDate", startDate), Restrictions.le("endDate", endDate))
                ))
                .addOrder(Order.asc("startDate"))
                .list();
    }

    public List<EmployeeWorkSchedule> getDefaultSchedulesForDateRange(Date startDate, Date endDate) {
        return getSession()
                .createCriteria(EmployeeWorkSchedule.class)
                .add(Restrictions.eq("defaultSchedule", true))
                .add(Restrictions.or(
                        Restrictions.and(Restrictions.isNull("endDate"), Restrictions.le("startDate", endDate)),
                        Restrictions.and(Restrictions.ge("startDate", startDate), Restrictions.le("startDate", endDate)),
                        Restrictions.and(Restrictions.ge("endDate", startDate), Restrictions.le("endDate", endDate))
                ))
                .addOrder(Order.asc("startDate"))
                .list();
    }

    public EmployeeWorkSchedule getDefaultScheduleForDate(Date date) {
        return (EmployeeWorkSchedule) getSession()
                .createCriteria(EmployeeWorkSchedule.class)
                .add(Restrictions.eq("defaultSchedule", true))
                .add(Restrictions.and(Restrictions.le("startDate", date),
                        Restrictions.or(Restrictions.isNull("endDate"), Restrictions.ge("endDate", date))
                ))
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
