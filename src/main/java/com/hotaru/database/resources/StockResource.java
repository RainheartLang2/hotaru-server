package com.hotaru.database.resources;

import com.hotaru.core.database.ArchivableResourceBase;
import com.hotaru.database.entities.Stock;

public class StockResource extends ArchivableResourceBase<Stock> {
    private static StockResource INSTANCE = new StockResource();

    public static StockResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StockResource();
        }
        return INSTANCE;
    }
}
