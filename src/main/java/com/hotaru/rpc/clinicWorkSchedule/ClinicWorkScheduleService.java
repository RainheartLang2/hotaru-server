package com.hotaru.rpc.clinicWorkSchedule;

import com.hotaru.business.managers.WorkScheduleManager;
import com.hotaru.core.entities.DaySchedule;
import com.hotaru.core.entities.TimeRange;
import com.hotaru.core.entities.WorkScheduleDeviation;
import com.hotaru.database.entities.WorkScheduleDeviationContainer;
import com.hotaru.database.entities.ClinicWorkSchedule;
import com.hotaru.database.resources.WorkScheduleDeviationResource;
import com.hotaru.database.resources.ClinicWorkScheduleResource;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ClinicWorkScheduleService {

    public ClinicScheduleInfo getAll() {
        List<ClinicWorkSchedule> workSchedules = ClinicWorkScheduleResource.getInstance().getAll();
        List<Integer> workScheduleIds = workSchedules.stream().map(schedule -> schedule.getId()).collect(Collectors.toList());
        workScheduleIds.add(null);
        List<WorkScheduleDeviationContainer> deviations = WorkScheduleDeviationResource.getInstance().getByWorkScheduleId(workScheduleIds);
        return new ClinicScheduleInfo(workSchedules, deviations);
    }

    public void setUseDefaultFlag(int clinicId, boolean useDefault) {
        ClinicWorkScheduleResource resource = ClinicWorkScheduleResource.getInstance();
        ClinicWorkSchedule schedule = resource.getByClinicId(clinicId);
        schedule.setUsesDefault(useDefault);
        resource.saveOrUpdate(schedule);
    }

    public void update(int clinicId, int dayNumber, List<TimeRange> records) {
        ClinicWorkScheduleResource resource = ClinicWorkScheduleResource.getInstance();
        ClinicWorkSchedule schedule;
        if (clinicId == 0) {
            schedule = resource.getDefaultSchedule();
        } else {
            schedule = resource.getByClinicId(clinicId);
        }
        schedule.getSchedule().setDaySchedule(dayNumber, new DaySchedule(records));
        resource.saveOrUpdate(schedule);
    }

    public int createDeviation(String name, Integer workScheduleId, Date startDate, Date endDate, List<TimeRange> records) {
        return WorkScheduleManager.getInstance().createDeviation(name, workScheduleId, startDate, endDate, records);
    }

    public void updateDeviationDates(int id, Date startDate, Date endDate) {
        WorkScheduleManager.getInstance().updateDeviationDates(id, startDate, endDate);
    }

    public void updateDeviation(int id, String name, Integer workScheduleId, Date startDate, Date endDate, List<TimeRange> records) {
        WorkScheduleManager.getInstance().updateDeviation(id, name, workScheduleId, startDate, endDate, records);
    }

    public void deleteDeviation(int id) {
        WorkScheduleManager.getInstance().deleteDeviation(id);
    }

    public void update(ClinicWorkSchedule diagnosis) {
        ClinicWorkScheduleResource.getInstance().saveOrUpdate(diagnosis);
    }
}
