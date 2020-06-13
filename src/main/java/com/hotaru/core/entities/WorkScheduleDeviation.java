package com.hotaru.core.entities;

import java.util.Date;

public class WorkScheduleDeviation {
    private Date startDate;
    private Date endDate;
    private DaySchedule changes;

    public WorkScheduleDeviation() {}

    public WorkScheduleDeviation(Date startDate, Date endDate, DaySchedule changes) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.changes = changes;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public DaySchedule getChanges() {
        return changes;
    }

    public void setChanges(DaySchedule changes) {
        this.changes = changes;
    }
}
