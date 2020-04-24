package com.hotaru.rpc.clinic;

import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Clinic;
import com.hotaru.database.resources.ClinicResource;

import java.util.List;

public class ClinicService implements ClinicServiceBase {
    @Override
    public List<Clinic> getAll() {
        return ClinicResource.getInstance().getAllNotDeleted();
    }

    @Override
    public int add(Clinic clinic) throws ValidationException {
        return 0;
    }

    @Override
    public void update(Clinic clinic) throws ValidationException {

    }

    @Override
    public void delete(int id) {

    }
}
