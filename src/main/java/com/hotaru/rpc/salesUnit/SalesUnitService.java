package com.hotaru.rpc.salesUnit;

import com.hotaru.database.entities.SalesUnit;
import com.hotaru.database.resources.SalesUnitResource;

import java.util.List;

public class SalesUnitService {
    public List<SalesUnit> getAll() {
        return SalesUnitResource.getInstance().getAllNotDeleted();
    }

    public int add(SalesUnit category) {
        SalesUnitResource.getInstance().saveOrUpdate(category);
        return category.getId();
    }

    public void update(SalesUnit category) {
        SalesUnitResource.getInstance().saveOrUpdate(category);
    }

    public void delete(int id) {
        SalesUnitResource.getInstance().markDeleted(id);
    }
}
