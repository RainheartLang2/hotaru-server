package com.hotaru.rpc.diagnosis;

import com.hotaru.database.entities.Diagnosis;
import com.hotaru.database.resources.DiagnosisResource;

import java.util.List;

public class DiagnosisService {
    public List<Diagnosis> getAll() {
        return DiagnosisResource.getInstance().getAllNotDeleted();
    }

    public int add(Diagnosis diagnosis) {
        DiagnosisResource.getInstance().saveOrUpdate(diagnosis);
        return diagnosis.getId();
    }

    public void update(Diagnosis diagnosis) {
        DiagnosisResource.getInstance().saveOrUpdate(diagnosis);
    }

    public void delete(int id) {
        DiagnosisResource.getInstance().markDeleted(id);
    }
}
