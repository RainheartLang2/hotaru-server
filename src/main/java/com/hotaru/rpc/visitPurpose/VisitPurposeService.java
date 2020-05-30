package com.hotaru.rpc.visitPurpose;

import com.hotaru.database.entities.VisitPurpose;
import com.hotaru.database.resources.VisitPurposeResource;

import java.util.List;

public class VisitPurposeService {
    public List<VisitPurpose> getAll() {
        return VisitPurposeResource.getInstance().getAllNotDeleted();
    }

    public int add(VisitPurpose visitPurpose) {
        VisitPurposeResource.getInstance().saveOrUpdate(visitPurpose);
        return visitPurpose.getId();
    }

    public void update(VisitPurpose visitPurpose) {
        VisitPurposeResource.getInstance().saveOrUpdate(visitPurpose);
    }

    public void delete(int id) {
        VisitPurposeResource.getInstance().markDeleted(id);
    }
}
