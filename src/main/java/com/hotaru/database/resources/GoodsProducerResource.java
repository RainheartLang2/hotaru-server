package com.hotaru.database.resources;

import com.hotaru.core.database.ArchivableResourceBase;
import com.hotaru.database.entities.GoodsProducer;

public class GoodsProducerResource extends ArchivableResourceBase<GoodsProducer> {
    private static GoodsProducerResource INSTANCE = new GoodsProducerResource();

    public static GoodsProducerResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GoodsProducerResource();
        }
        return INSTANCE;
    }
}
