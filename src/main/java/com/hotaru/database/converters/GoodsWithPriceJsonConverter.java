package com.hotaru.database.converters;

import com.hotaru.database.entities.GoodsPackWithPrice;

public class GoodsWithPriceJsonConverter extends DataBaseJsonConverter<GoodsPackWithPrice> {
    @Override
    protected Class<GoodsPackWithPrice> getEntityClass() {
        return GoodsPackWithPrice.class;
    }
}
