package com.hotaru.rpc.clinicWorkSchedule;

import com.hotaru.database.entities.ClinicScheduleDeviation;
import com.hotaru.database.entities.ClinicWorkSchedule;

import java.util.List;

public class ClinicScheduleInfo {
    private List<ClinicWorkSchedule> workSchedules;
    private List<ClinicScheduleDeviation> deviations;

    public ClinicScheduleInfo(List<ClinicWorkSchedule> workSchedules, List<ClinicScheduleDeviation> deviations) {
        this.workSchedules = workSchedules;
        this.deviations = deviations;
    }

    public List<ClinicWorkSchedule> getWorkSchedules() {
        return workSchedules;
    }

    public void setWorkSchedules(List<ClinicWorkSchedule> workSchedules) {
        this.workSchedules = workSchedules;
    }

    public List<ClinicScheduleDeviation> getDeviations() {
        return deviations;
    }

    public void setDeviations(List<ClinicScheduleDeviation> deviations) {
        this.deviations = deviations;
    }
}
