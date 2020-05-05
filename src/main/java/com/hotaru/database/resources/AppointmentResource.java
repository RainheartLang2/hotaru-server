package com.hotaru.database.resources;

import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.Appointment;

import java.util.Date;

public class AppointmentResource extends ResourceBase<Appointment> {

    private static AppointmentResource INSTANCE = new AppointmentResource();

    public static AppointmentResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppointmentResource();
        }
        return INSTANCE;
    }

    public void updateDates(int id, Date startDate, Date endDate) {
        Appointment appointment = getById(id);
        appointment.setStartDate(startDate);
        appointment.setEndDate(endDate);
        saveOrUpdate(appointment);
    }

    private AppointmentResource() {
        super();
    }
}
