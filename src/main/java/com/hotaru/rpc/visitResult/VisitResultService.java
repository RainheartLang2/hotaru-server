package com.hotaru.rpc.visitResult;

import com.hotaru.database.entities.VisitResult;
import com.hotaru.database.resources.VisitResultResource;

import java.util.List;

public class VisitResultService {
    public List<VisitResult> getAll() {
        return VisitResultResource.getInstance().getAllNotDeleted();
    }

    public int add(VisitResult species) {
        VisitResultResource.getInstance().saveOrUpdate(species);
        return species.getId();
    }

    public void update(VisitResult species) {
        VisitResultResource.getInstance().saveOrUpdate(species);
    }

    public void delete(int id) {
        VisitResultResource.getInstance().markDeleted(id);
    }
}
