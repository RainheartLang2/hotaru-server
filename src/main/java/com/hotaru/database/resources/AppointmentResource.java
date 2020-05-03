package com.hotaru.database.resources;

import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.Appointment;

public class AppointmentResource extends ResourceBase<Appointment> {

    private static AppointmentResource INSTANCE = new AppointmentResource();

    public static AppointmentResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppointmentResource();
        }
        return INSTANCE;
    }

    private AppointmentResource() {
        super();
    }
}
