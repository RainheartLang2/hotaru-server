package com.hotaru.rpc.appointment;

import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Appointment;
import com.hotaru.database.resources.AppointmentResource;

import java.util.List;

public class AppointmentService {
    public List<Appointment> getAll() {
        return AppointmentResource.getInstance().getAll();
    }

    public int add(Appointment species) throws ValidationException {
        //TODO: add validation
        AppointmentResource.getInstance().saveOrUpdate(species);
        return species.getId();
    }

    public void update(Appointment species) throws ValidationException {
        //TODO: add validtion
        AppointmentResource.getInstance().saveOrUpdate(species);
    }

    public void delete(int id) {
        AppointmentResource.getInstance().delete(id);
    }
}
