package com.hotaru.rpc.stock;

import com.hotaru.database.entities.Stock;
import com.hotaru.database.resources.StockResource;

import java.util.List;

public class StockService {
    public List<Stock> getAll() {
        return StockResource.getInstance().getAllNotDeleted();
    }

    public int add(Stock stock) {
        StockResource.getInstance().saveOrUpdate(stock);
        return stock.getId();
    }

    public void update(Stock stock) {
        StockResource.getInstance().saveOrUpdate(stock);
    }

    public void delete(int id) {
        StockResource.getInstance().markDeleted(id);
    }
}
