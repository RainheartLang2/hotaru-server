package com.hotaru.database.resources;

public class GoodsDocumentResource {
    private static GoodsDocumentResource INSTANCE = new GoodsDocumentResource();

    public static GoodsDocumentResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GoodsDocumentResource();
        }
        return INSTANCE;
    }
}
