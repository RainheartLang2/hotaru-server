package com.hotaru.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateHelper {
    public static long getDifferenceInDays(Date first, Date second) {
        long diff = second.getTime() - first.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public static Date getNextDay(Date date) {
        Calendar calendar = toCalendar(date);
        calendar.add(Calendar.DATE, 1);
        return toDate(calendar);
    }

    public static Calendar toCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date toDate(Calendar calendar) {
        return new Date(calendar.getTimeInMillis());
    }

    public static Date getPureDate(Date date) {
        return new Date(date.getYear(), date.getMonth(), date.getDate());
    }
    public static Date getCurrentDate() {
        return getPureDate(new Date());
    }
}
