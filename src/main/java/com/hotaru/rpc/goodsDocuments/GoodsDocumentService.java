package com.hotaru.rpc.goodsDocuments;

import com.hotaru.business.managers.DocumentManager;
import com.hotaru.database.entities.GoodsDocument;
import com.hotaru.database.resources.GoodsDocumentResource;

import java.util.List;

public class GoodsDocumentService {
    public List<GoodsDocument> getAll() {
        return GoodsDocumentResource.getInstance().getAll();
    }

    public GoodsDocument add(GoodsDocument document, boolean execute) {
        DocumentManager.getInstance().addOrUpdate(document, execute);
        return document;
    }

    public GoodsDocument update(GoodsDocument document, boolean execute) {
        DocumentManager.getInstance().addOrUpdate(document, execute);
        return document;
    }

    public GoodsDocument cancel(int documentId) {
        GoodsDocument document = GoodsDocumentResource.getInstance().getById(documentId);
        DocumentManager.getInstance().cancel(document);
        return document;
    }
}
