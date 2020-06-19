package com.hotaru.core.entities;

import java.util.List;

public class WorkSchedule {
    private int length;
    private List<DaySchedule> schedule;
    private boolean weekly;

    public WorkSchedule() {}

    public WorkSchedule(int length, boolean weekly, List<DaySchedule> schedule) {
        this.length = length;
        this.schedule = schedule;
        this.weekly = weekly;
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

    public boolean isWeekly() {
        return weekly;
    }

    public void setWeekly(boolean weekly) {
        this.weekly = weekly;
    }
}
