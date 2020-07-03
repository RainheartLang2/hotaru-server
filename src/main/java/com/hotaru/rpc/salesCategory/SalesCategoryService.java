package com.hotaru.rpc.salesCategory;

import com.hotaru.database.entities.SalesCategory;
import com.hotaru.database.resources.SalesCategoryResource;

import java.util.List;

public class SalesCategoryService {
    public List<SalesCategory> getAll() {
        return SalesCategoryResource.getInstance().getAllNotDeleted();
    }

    public int add(SalesCategory category) {
        SalesCategoryResource.getInstance().saveOrUpdate(category);
        return category.getId();
    }

    public void update(SalesCategory category) {
        SalesCategoryResource.getInstance().saveOrUpdate(category);
    }

    public void delete(int id) {
        SalesCategoryResource.getInstance().markDeleted(id);
    }
}
