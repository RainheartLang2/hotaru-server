package com.hotaru.database.resources;

import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.GoodsPack;

public class GoodsPackResource extends ResourceBase<GoodsPack> {
    private static GoodsPackResource INSTANCE = new GoodsPackResource();

    public static GoodsPackResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GoodsPackResource();
        }
        return INSTANCE;
    }
}
