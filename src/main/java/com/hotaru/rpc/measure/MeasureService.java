package com.hotaru.rpc.measure;

import com.hotaru.database.entities.Measure;
import com.hotaru.database.resources.MeasureResource;

import java.util.List;

public class MeasureService {
    public List<Measure> getAll() {
        return MeasureResource.getInstance().getAllNotDeleted();
    }

    public int add(Measure species) {
        MeasureResource.getInstance().saveOrUpdate(species);
        return species.getId();
    }

    public void update(Measure species) {
        MeasureResource.getInstance().saveOrUpdate(species);
    }

    public void delete(int id) {
        MeasureResource.getInstance().markDeleted(id);
    }
}
