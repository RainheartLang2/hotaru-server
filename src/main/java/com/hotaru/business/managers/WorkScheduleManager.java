package com.hotaru.business.managers;

import com.hotaru.core.entities.DaySchedule;
import com.hotaru.core.entities.TimeRange;
import com.hotaru.database.entities.WorkScheduleDeviationContainer;
import com.hotaru.database.resources.WorkScheduleDeviationResource;

import java.util.Date;
import java.util.List;

public class WorkScheduleManager {
    private static WorkScheduleManager INSTANCE = new WorkScheduleManager();

    public static WorkScheduleManager getInstance() {
        return INSTANCE;
    }

    private WorkScheduleManager() {}

    public int createDeviation(String name, Integer workScheduleId, Date startDate, Date endDate, List<TimeRange> records) {
        WorkScheduleDeviationResource resource = WorkScheduleDeviationResource.getInstance();
        WorkScheduleDeviationContainer deviation = new WorkScheduleDeviationContainer();
        deviation.setName(name);
        deviation.setWorkScheduleId(workScheduleId);
        deviation.setDeviationData(startDate, endDate, new DaySchedule(records));
        resource.saveOrUpdate(deviation);
        return deviation.getId();
    }

    public void updateDeviationDates(int id, Date startDate, Date endDate) {
        WorkScheduleDeviationResource resource = WorkScheduleDeviationResource.getInstance();
        WorkScheduleDeviationContainer deviation = resource.getById(id);
        deviation.setStartDate(startDate);
        deviation.setEndDate(endDate);
        resource.saveOrUpdate(deviation);
    }

    public void updateDeviation(int id, String name, Integer workScheduleId, Date startDate, Date endDate, List<TimeRange> records) {
        WorkScheduleDeviationResource resource = WorkScheduleDeviationResource.getInstance();
        WorkScheduleDeviationContainer deviation = resource.getById(id);
        deviation.setName(name);
        deviation.setWorkScheduleId(workScheduleId);
        deviation.setStartDate(startDate);
        deviation.setEndDate(endDate);
        deviation.setChanges(new DaySchedule(records));
        resource.saveOrUpdate(deviation);
    }

    public void deleteDeviation(int id) {
        WorkScheduleDeviationResource.getInstance().delete(id);
    }

}
