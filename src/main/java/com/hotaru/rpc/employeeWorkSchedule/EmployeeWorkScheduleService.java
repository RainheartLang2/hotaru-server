package com.hotaru.rpc.employeeWorkSchedule;

import com.hotaru.business.logic.enums.DeviationType;
import com.hotaru.business.managers.EmployeeManager;
import com.hotaru.business.managers.WorkScheduleManager;
import com.hotaru.core.entities.DaySchedule;
import com.hotaru.core.entities.TimeRange;
import com.hotaru.core.entities.WorkSchedule;
import com.hotaru.core.util.CollectionUtils;
import com.hotaru.database.entities.EmployeeWorkSchedule;
import com.hotaru.database.entities.WorkScheduleDeviationContainer;
import com.hotaru.database.resources.EmployeeWorkScheduleResource;
import com.hotaru.database.resources.WorkScheduleDeviationResource;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeWorkScheduleService {
    public EmployeeScheduleInfo getAll() {
        List<EmployeeWorkSchedule> workSchedules = EmployeeWorkScheduleResource.getInstance().getAll();
        List<Integer> workScheduleIds = workSchedules.stream().map(schedule -> schedule.getId()).collect(Collectors.toList());
        workScheduleIds.add(null);
        List<WorkScheduleDeviationContainer> deviations = WorkScheduleDeviationResource.getInstance().getByWorkScheduleId(DeviationType.Clinic, workScheduleIds);

        return new EmployeeScheduleInfo(workSchedules, deviations);
    }

    public void setUseDefaultFlag(int employeeId, boolean useDefault) {
        EmployeeWorkScheduleResource resource = EmployeeWorkScheduleResource.getInstance();
        EmployeeWorkSchedule schedule = resource.getByEmployeeId(employeeId);
        schedule.setUsesDefault(useDefault);
        resource.saveOrUpdate(schedule);
    }

    public void update(int employeeId, int dayNumber, List<TimeRange> records) {
        EmployeeWorkSchedule schedule = EmployeeManager.getInstance().getWorkScheduleByEmployeeId(employeeId);
        schedule.getSchedule().setDaySchedule(dayNumber, new DaySchedule(records));

        EmployeeWorkScheduleResource resource = EmployeeWorkScheduleResource.getInstance();
        resource.saveOrUpdate(schedule);
    }

    public void setScheduleLength(int employeeId, int scheduleLength) {
        EmployeeWorkSchedule schedule = EmployeeManager.getInstance().getWorkScheduleByEmployeeId(employeeId);
        schedule.setSchedule(new WorkSchedule(scheduleLength, false, CollectionUtils.fillArray(scheduleLength, new DaySchedule())));
        EmployeeWorkScheduleResource resource = EmployeeWorkScheduleResource.getInstance();
        resource.saveOrUpdate(schedule);
    }

    public void setWeekly(int employeeId) {
        EmployeeWorkSchedule schedule = EmployeeManager.getInstance().getWorkScheduleByEmployeeId(employeeId);
        schedule.setSchedule(new WorkSchedule(7, true, CollectionUtils.fillArray(7, new DaySchedule())));
        EmployeeWorkScheduleResource resource = EmployeeWorkScheduleResource.getInstance();
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
}
