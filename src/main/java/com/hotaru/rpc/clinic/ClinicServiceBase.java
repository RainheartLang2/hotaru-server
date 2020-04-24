package com.hotaru.rpc.clinic;

import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Clinic;

import java.util.List;

public interface ClinicServiceBase {
    List<Clinic> getAll();
    int add(Clinic clinic) throws ValidationException;
    void update(Clinic clinic) throws ValidationException;
    void delete(int id);
}
