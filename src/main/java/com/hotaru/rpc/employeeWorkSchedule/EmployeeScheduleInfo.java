package com.hotaru.rpc.employeeWorkSchedule;

import com.hotaru.database.entities.EmployeeWorkSchedule;
import com.hotaru.database.entities.WorkScheduleDeviationContainer;

import java.util.List;

public class EmployeeScheduleInfo {
    private List<EmployeeWorkSchedule> workSchedules;
    private List<WorkScheduleDeviationContainer> deviations;

    public EmployeeScheduleInfo(List<EmployeeWorkSchedule> workSchedules, List<WorkScheduleDeviationContainer> deviations) {
        this.workSchedules = workSchedules;
        this.deviations = deviations;
    }

    public List<EmployeeWorkSchedule> getWorkSchedules() {
        return workSchedules;
    }

    public void setWorkSchedules(List<EmployeeWorkSchedule> workSchedules) {
        this.workSchedules = workSchedules;
    }

    public List<WorkScheduleDeviationContainer> getDeviations() {
        return deviations;
    }

    public void setDeviations(List<WorkScheduleDeviationContainer> deviations) {
        this.deviations = deviations;
    }
}
