package com.hotaru.business.managers;

import com.hotaru.core.entities.DaySchedule;
import com.hotaru.core.entities.WorkSchedule;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.core.util.CollectionUtils;
import com.hotaru.database.entities.*;
import com.hotaru.database.resources.EmployeeResource;
import com.hotaru.database.resources.EmployeeWorkScheduleResource;
import com.hotaru.database.resources.LoginResource;
import com.hotaru.rest.validation.forms.EmployeeValidationForm;

import java.util.Date;

public class EmployeeManager {
    private static EmployeeManager INSTANCE = new EmployeeManager();

    private static int DEFAULT_WORK_SCHEDULE_LENGTH = 7;
    private static DaySchedule DEFAULT_DAY_SCHEDULE = new DaySchedule();

    public static EmployeeManager getInstance() {
        return INSTANCE;
    }

    public EmployeeManager() {}

    public int addEmployee(Employee employee, Login login) throws ValidationException {
        EmployeeValidationForm.INSTANCE.validate(employee);
        EmployeeResource.getInstance().saveOrUpdate(employee);
        int employeeId = employee.getId();
        login.setUserId(employeeId);
        LoginResource.getInstance().saveOrUpdate(login);

        EmployeeWorkSchedule employeeWorkSchedule = new EmployeeWorkSchedule(employee.getId(), new Date(), false, true,
                new WorkSchedule(DEFAULT_WORK_SCHEDULE_LENGTH,
                                true,
                                        CollectionUtils.fillArray(DEFAULT_WORK_SCHEDULE_LENGTH, DEFAULT_DAY_SCHEDULE)));
        EmployeeWorkScheduleResource.getInstance().saveOrUpdate(employeeWorkSchedule);
        return employeeId;
    }

    public EmployeeWorkSchedule getWorkScheduleByEmployeeId(int employeeId) {
        EmployeeWorkScheduleResource resource = EmployeeWorkScheduleResource.getInstance();
        if (employeeId == 0) {
            return resource.getDefaultSchedule();
        } else {
            return resource.getActualByEmployeeId(employeeId);
        }
    }
}
