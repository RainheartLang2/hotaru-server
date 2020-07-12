package com.hotaru.rpc.goodsDocuments;

import com.hotaru.business.managers.DocumentManager;
import com.hotaru.database.entities.GoodsDocument;
import com.hotaru.database.resources.GoodsDocumentResource;

import java.util.List;

public class GoodsDocumentService {
    public List<GoodsDocument> getAll() {
        return GoodsDocumentResource.getInstance().getAll();
    }

    public int add(GoodsDocument document, boolean execute) {
        DocumentManager.getInstance().addOrUpdate(document, execute);
        return document.getId();
    }

    public void update(GoodsDocument document, boolean execute) {
        DocumentManager.getInstance().addOrUpdate(document, execute);
    }

    public void cancel(int documentId) {
        DocumentManager.getInstance().cancel(GoodsDocumentResource.getInstance().getById(documentId));
    }
}
