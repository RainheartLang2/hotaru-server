package com.hotaru.database.resources;

import com.hotaru.core.database.ArchivableResourceBase;
import com.hotaru.database.entities.SalesCategory;

public class SalesCategoryResource extends ArchivableResourceBase<SalesCategory> {
    private static SalesCategoryResource INSTANCE = new SalesCategoryResource();

    public static SalesCategoryResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SalesCategoryResource();
        }
        return INSTANCE;
    }
}
