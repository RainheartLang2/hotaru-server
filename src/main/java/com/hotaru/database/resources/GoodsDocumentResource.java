package com.hotaru.database.resources;

import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.GoodsDocument;

public class GoodsDocumentResource extends ResourceBase<GoodsDocument> {
    private static GoodsDocumentResource INSTANCE = new GoodsDocumentResource();

    public static GoodsDocumentResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GoodsDocumentResource();
        }
        return INSTANCE;
    }
}
