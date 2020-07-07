package com.hotaru.rpc.goodsProducer;

import com.hotaru.database.entities.GoodsProducer;
import com.hotaru.database.resources.GoodsProducerResource;

import java.util.List;

public class GoodsProducerService {
    public List<GoodsProducer> getAll() {
        return GoodsProducerResource.getInstance().getAllNotDeleted();
    }

    public int add(GoodsProducer animalCOlor) {
        GoodsProducerResource.getInstance().saveOrUpdate(animalCOlor);
        return animalCOlor.getId();
    }

    public void update(GoodsProducer producer) {
        GoodsProducerResource.getInstance().saveOrUpdate(producer);
    }

    public void delete(int id) {
        GoodsProducerResource.getInstance().markDeleted(id);
    }
}
