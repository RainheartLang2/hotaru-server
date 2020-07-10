package com.hotaru.database.resources;

import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.GoodsPack;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class GoodsPackResource extends ResourceBase<GoodsPack> {
    private static GoodsPackResource INSTANCE = new GoodsPackResource();

    public static GoodsPackResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GoodsPackResource();
        }
        return INSTANCE;
    }

    public List<GoodsPack> getAllGoodsPackByStock(int stockId) {
        return getSession().
                createCriteria(daoClass)
                .add(Restrictions.eq("stockId", stockId))
                .list();
    }
}
