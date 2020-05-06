package com.hotaru.rpc.appointment;

import com.hotaru.business.logic.enums.ClientType;
import com.hotaru.core.entities.DateRange;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Appointment;
import com.hotaru.database.entities.Client;
import com.hotaru.database.resources.AppointmentResource;
import com.hotaru.database.resources.ClientInfoResource;
import com.hotaru.rest.validation.forms.AppointmentValidationForm;
import com.hotaru.rest.validation.forms.DateRangeValidationForm;

import java.util.Date;
import java.util.List;

public class AppointmentService {
    public List<Appointment> getAll() {
        return AppointmentResource.getInstance().getAll();
    }

    public Appointment add(Appointment appointment, Client client) throws ValidationException {
        AppointmentValidationForm.INSTANCE.validate(appointment);
        if (appointment.getClientId() == null) {
            //TODO: add validation
            client.setType(ClientType.TEMPORARY);
            ClientInfoResource.getInstance().saveOrUpdate(client);
            appointment.setClientId(client.getId());
        } else if (client != null) {
            throw new ValidationException("there should not be clientinfo if client id specified");
        }
        AppointmentResource.getInstance().saveOrUpdate(appointment);
        return appointment;
    }

    public void update(Appointment appointment, Client client) throws ValidationException {
        AppointmentValidationForm.INSTANCE.validate(appointment);
        //TODO: add validation
        if (client != null) {
            ClientInfoResource.getInstance().saveOrUpdate(client);
        }
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
