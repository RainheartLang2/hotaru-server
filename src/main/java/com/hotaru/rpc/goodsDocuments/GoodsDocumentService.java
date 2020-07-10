package com.hotaru.rpc.goodsDocuments;

import com.hotaru.database.entities.GoodsDocument;
import com.hotaru.database.resources.GoodsDocumentResource;

import java.util.List;

public class GoodsDocumentService {
    public List<GoodsDocument> getAll() {
        return GoodsDocumentResource.getInstance().getAll();
    }

    public int add(GoodsDocument document, boolean execute) {
        GoodsDocumentResource.getInstance().saveOrUpdate(document);
        return document.getId();
    }

    public void update(GoodsDocument document) {
        GoodsDocumentResource.getInstance().saveOrUpdate(document);
    }
}
