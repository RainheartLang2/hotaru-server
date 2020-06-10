package com.hotaru.core.entities;

import java.util.List;

public class WorkSchedule {
    private int length;
    private List<DaySchedule> schedule;

    public WorkSchedule() {}

    public WorkSchedule(int length, List<DaySchedule> schedule) {
        this.length = length;
        this.schedule = schedule;
    }

    public int getLength() {
        return length;
    }

    public List<DaySchedule> getSchedule() {
        return schedule;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setSchedule(List<DaySchedule> schedule) {
        this.schedule = schedule;
    }

    public DaySchedule getDaySchedule(int dayNumber) {
        return schedule.get(dayNumber);
    }

    public void setDaySchedule(int dayNumber, DaySchedule daySchedule) {
        schedule.set(dayNumber, daySchedule);
    }
}
