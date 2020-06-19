package com.hotaru.rpc.employeeWorkSchedule;

import com.hotaru.database.entities.EmployeeWorkSchedule;

import java.util.List;

public class EmployeeScheduleInfo {
    private List<EmployeeWorkSchedule> workSchedules;

    public EmployeeScheduleInfo(List<EmployeeWorkSchedule> workSchedules) {
        this.workSchedules = workSchedules;
    }

    public List<EmployeeWorkSchedule> getWorkSchedules() {
        return workSchedules;
    }

    public void setWorkSchedules(List<EmployeeWorkSchedule> workSchedules) {
        this.workSchedules = workSchedules;
    }
}
