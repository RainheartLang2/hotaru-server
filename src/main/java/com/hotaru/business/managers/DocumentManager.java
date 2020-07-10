package com.hotaru.business.managers;

import com.hotaru.business.logic.enums.DocumentState;
import com.hotaru.database.entities.GoodsDocument;
import com.hotaru.database.entities.GoodsPack;
import com.hotaru.database.entities.GoodsPackWithPrice;
import com.hotaru.database.resources.GoodsDocumentResource;
import com.hotaru.database.resources.GoodsPackResource;

public class DocumentManager {
    private static DocumentManager INSTANCE = new DocumentManager();

    public static DocumentManager getInstance() {
        return INSTANCE;
    }

    private DocumentManager() {}

    public void add(GoodsDocument document, boolean execute) {
        GoodsDocumentResource.getInstance().saveOrUpdate(document);
        if (execute) {
            execute(document);
        }
    }

    public void cancel(GoodsDocument document) {
        document.setDocumentState(DocumentState.Canceled);
        GoodsDocumentResource.getInstance().saveOrUpdate(document);
    }

    public void execute(GoodsDocument document) {
        GoodsPackResource goodsPackResource = GoodsPackResource.getInstance();
        for (GoodsPackWithPrice goodsPack: document.getGoods().getList()) {
            goodsPackResource.saveOrUpdate(new GoodsPack(goodsPack, document));
        }
        document.setDocumentState(DocumentState.Executed);
        GoodsDocumentResource.getInstance().saveOrUpdate(document);
    }
}
