package com.hotaru.rpc.appointment;

import com.hotaru.core.entities.DateRange;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Appointment;
import com.hotaru.database.resources.AppointmentResource;
import com.hotaru.rest.validation.forms.AppointmentValidationForm;
import com.hotaru.rest.validation.forms.DateRangeValidationForm;

import java.util.Date;
import java.util.List;

public class AppointmentService {
    public List<Appointment> getAll() {
        return AppointmentResource.getInstance().getAll();
    }

    public int add(Appointment appointment) throws ValidationException {
        AppointmentValidationForm.INSTANCE.validate(appointment);
        AppointmentResource.getInstance().saveOrUpdate(appointment);
        return appointment.getId();
    }

    public void update(Appointment appointment) throws ValidationException {
        AppointmentValidationForm.INSTANCE.validate(appointment);
        AppointmentResource.getInstance().saveOrUpdate(appointment);
    }

    public void updateDates(int appointmentId, Date startDate, Date endDate) throws ValidationException {
        DateRangeValidationForm.INSTANCE.validate(new DateRange(startDate, endDate));
        AppointmentResource.getInstance().updateDates(appointmentId, startDate, endDate);
    }

    public void delete(int id) {
        AppointmentResource.getInstance().delete(id);
    }
}
