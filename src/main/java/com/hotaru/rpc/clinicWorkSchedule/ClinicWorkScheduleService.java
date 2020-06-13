package com.hotaru.rpc.clinicWorkSchedule;

import com.hotaru.core.entities.DaySchedule;
import com.hotaru.core.entities.TimeRange;
import com.hotaru.core.entities.WorkScheduleDeviation;
import com.hotaru.database.entities.ClinicScheduleDeviation;
import com.hotaru.database.entities.ClinicWorkSchedule;
import com.hotaru.database.resources.ClinicScheduleDeviationResource;
import com.hotaru.database.resources.ClinicWorkScheduleResource;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ClinicWorkScheduleService {

    public ClinicScheduleInfo getAll() {
        List<ClinicWorkSchedule> workSchedules = ClinicWorkScheduleResource.getInstance().getAll();
        List<Integer> workScheduleIds = workSchedules.stream().map(schedule -> schedule.getId()).collect(Collectors.toList());
        workScheduleIds.add(null);
        List<ClinicScheduleDeviation> deviations = ClinicScheduleDeviationResource.getInstance().getByWorkScheduleId(workScheduleIds);
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
        ClinicScheduleDeviationResource resource = ClinicScheduleDeviationResource.getInstance();
        ClinicScheduleDeviation deviation = new ClinicScheduleDeviation();
        deviation.setName(name);
        deviation.setWorkScheduleId(workScheduleId);
        deviation.setDeviationData(new WorkScheduleDeviation(startDate, endDate, new DaySchedule(records)));
        resource.saveOrUpdate(deviation);
        return deviation.getId();
    }

    public void updateDeviationDates(int id, Date startDate, Date endDate) {
        ClinicScheduleDeviationResource resource = ClinicScheduleDeviationResource.getInstance();
        ClinicScheduleDeviation deviation = resource.getById(id);
        deviation.getDeviationData().setStartDate(startDate);
        deviation.getDeviationData().setEndDate(endDate);
        resource.saveOrUpdate(deviation);
    }

    public void updateDeviation(int id, String name, Integer workScheduleId, Date startDate, Date endDate, List<TimeRange> records) {
        ClinicScheduleDeviationResource resource = ClinicScheduleDeviationResource.getInstance();
        ClinicScheduleDeviation deviation = resource.getById(id);
        deviation.setName(name);
        deviation.setWorkScheduleId(workScheduleId);
        deviation.getDeviationData().setStartDate(startDate);
        deviation.getDeviationData().setEndDate(endDate);
        deviation.getDeviationData().setChanges(new DaySchedule(records));
        resource.saveOrUpdate(deviation);
    }

    public void deleteDeviation(int id) {
        ClinicScheduleDeviationResource.getInstance().delete(id);
    }

    public void update(ClinicWorkSchedule diagnosis) {
        ClinicWorkScheduleResource.getInstance().saveOrUpdate(diagnosis);
    }
}
