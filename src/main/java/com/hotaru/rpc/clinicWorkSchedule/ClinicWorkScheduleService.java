package com.hotaru.rpc.clinicWorkSchedule;

import com.hotaru.core.entities.DaySchedule;
import com.hotaru.core.entities.TimeRange;
import com.hotaru.database.entities.ClinicWorkSchedule;
import com.hotaru.database.resources.ClinicWorkScheduleResource;

import java.util.List;

public class ClinicWorkScheduleService {
    public List<ClinicWorkSchedule> getAll() {
        return ClinicWorkScheduleResource.getInstance().getAll();
    }

    public void update(int id, int dayNumber, List<TimeRange> records) {
        ClinicWorkScheduleResource resource = ClinicWorkScheduleResource.getInstance();
        ClinicWorkSchedule schedule = resource.getById(id);
        schedule.getSchedule().setDaySchedule(dayNumber, new DaySchedule(records));
        resource.saveOrUpdate(schedule);
    }

    public void update(ClinicWorkSchedule diagnosis) {
        ClinicWorkScheduleResource.getInstance().saveOrUpdate(diagnosis);
    }
}