package com.hotaru.rpc.visitResult;

import com.hotaru.database.entities.VisitResult;
import com.hotaru.database.resources.VisitResultResource;

import java.util.List;

public class VisitResultService {
    public List<VisitResult> getAll() {
        return VisitResultResource.getInstance().getAllNotDeleted();
    }

    public int add(VisitResult visitResult) {
        VisitResultResource.getInstance().saveOrUpdate(visitResult);
        return visitResult.getId();
    }

    public void update(VisitResult visitResult) {
        VisitResultResource.getInstance().saveOrUpdate(visitResult);
    }

    public void delete(int id) {
        VisitResultResource.getInstance().markDeleted(id);
    }
}
