package com.hotaru.rpc.appointment;

import com.hotaru.business.logic.enums.ClientType;
import com.hotaru.core.entities.DateRange;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Appointment;
import com.hotaru.database.entities.Client;
import com.hotaru.database.entities.Pet;
import com.hotaru.database.resources.AppointmentResource;
import com.hotaru.database.resources.ClientInfoResource;
import com.hotaru.database.resources.PetResource;
import com.hotaru.rest.validation.forms.AppointmentValidationForm;
import com.hotaru.rest.validation.forms.DateRangeValidationForm;

import java.util.Date;
import java.util.List;

public class AppointmentService {
    public List<Appointment> getAll() {
        return AppointmentResource.getInstance().getAll();
    }

    public Appointment add(Appointment appointment, Client client, Pet pet) throws ValidationException {
        AppointmentValidationForm.INSTANCE.validate(appointment);
        if (client != null) {
            //TODO: add validation
            client.setType(ClientType.TEMPORARY);
            ClientInfoResource.getInstance().saveOrUpdate(client);
            appointment.setClientId(client.getId());
            if (pet != null) {
                pet.setOwnerId(client.getId());
                PetResource.getInstance().saveOrUpdate(pet);
            }
        }

        AppointmentResource.getInstance().saveOrUpdate(appointment);
        return appointment;
    }

    public void update(Appointment appointment, Client client, Pet pet) throws ValidationException {
        AppointmentValidationForm.INSTANCE.validate(appointment);
        //TODO: add validation
        if (appointment.getClientId() == null && client != null) {
            //TODO: is client really always will be temporary here?
            client.setType(ClientType.TEMPORARY);
            appointment.setClientId(client.getId());
        }
        if (client != null) {
            ClientInfoResource.getInstance().saveOrUpdate(client);
            if (pet != null) {
                pet.setOwnerId(client.getId());
                PetResource.getInstance().saveOrUpdate(pet);
            }
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