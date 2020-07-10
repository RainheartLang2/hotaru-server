package com.hotaru.rpc.stock;

import com.hotaru.database.entities.GoodsPack;
import com.hotaru.database.entities.Stock;
import com.hotaru.database.resources.GoodsPackResource;
import com.hotaru.database.resources.StockResource;

import java.util.List;

public class StockService {
    public List<Stock> getAll() {
        return StockResource.getInstance().getAllNotDeleted();
    }

    public List<GoodsPack> getAllGoods(int stockId) {
        return GoodsPackResource.getInstance().getAllGoodsPackByStock(stockId);
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
