package com.hotaru.rpc.clinic;

import com.hotaru.business.managers.ClinicManager;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Clinic;
import com.hotaru.database.entities.ClinicWorkSchedule;
import com.hotaru.database.resources.ClinicResource;
import com.hotaru.rest.validation.forms.ClinicValidationForm;

import java.util.List;

public class ClinicService implements ClinicServiceBase {
    @Override
    public List<Clinic> getAll() {
        return ClinicResource.getInstance().getAllNotDeleted();
    }

    @Override
    public int add(Clinic clinic) throws ValidationException {
        ClinicValidationForm.INSTANCE.validate(clinic);
        ClinicManager.getInstance().addClinic(clinic);
        return clinic.getId();
    }

    @Override
    public void update(Clinic clinic) throws ValidationException {
        ClinicValidationForm.INSTANCE.validate(clinic);
        ClinicResource.getInstance().saveOrUpdate(clinic);
    }

    @Override
    public void delete(int id) {
        ClinicResource.getInstance().markDeleted(id);
    }
}
