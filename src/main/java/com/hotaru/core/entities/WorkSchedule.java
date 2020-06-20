package com.hotaru.core.entities;

import com.hotaru.core.util.CollectionUtils;
import com.hotaru.utils.DateHelper;

import java.util.Date;
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

    public void setScheduleLength(int length) {
        this.length = length;
        this.weekly = false;
        this.schedule = CollectionUtils.fillArray(7, new DaySchedule());
    }

    public void setWeeklyFlag() {
        this.length = 7;
        this.weekly = true;
        this.schedule = CollectionUtils.fillArray(7, new DaySchedule());
    }

    public DaySchedule getDayScheduleForDate(Date startDate, Date date) {
        if (this.weekly) {
            return this.schedule.get(date.getDay());
        }

        long difference = DateHelper.getDifferenceInDays(startDate, date);
        if (difference < 0) {
            return null;
        }
        int index = (int) (difference % this.length);
        return this.schedule.get(index);
    }
}
