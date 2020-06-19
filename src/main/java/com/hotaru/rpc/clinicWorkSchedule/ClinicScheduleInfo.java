package com.hotaru.rpc.clinicWorkSchedule;

import com.hotaru.database.entities.WorkScheduleDeviationContainer;
import com.hotaru.database.entities.ClinicWorkSchedule;

import java.util.List;

public class ClinicScheduleInfo {
    private List<ClinicWorkSchedule> workSchedules;
    private List<WorkScheduleDeviationContainer> deviations;

    public ClinicScheduleInfo(List<ClinicWorkSchedule> workSchedules, List<WorkScheduleDeviationContainer> deviations) {
        this.workSchedules = workSchedules;
        this.deviations = deviations;
    }

    public List<ClinicWorkSchedule> getWorkSchedules() {
        return workSchedules;
    }

    public void setWorkSchedules(List<ClinicWorkSchedule> workSchedules) {
        this.workSchedules = workSchedules;
    }

    public List<WorkScheduleDeviationContainer> getDeviations() {
        return deviations;
    }

    public void setDeviations(List<WorkScheduleDeviationContainer> deviations) {
        this.deviations = deviations;
    }
}
