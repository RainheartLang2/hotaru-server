package com.hotaru.business.managers;

import com.hotaru.business.logic.enums.DocumentState;
import com.hotaru.business.logic.enums.ShipingType;
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

    public void addOrUpdate(GoodsDocument document, boolean execute) {
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
        if (document.getShipingType() == ShipingType.Income) {
            executeIncomeGoodsDocument(document);
        } else if (document.getShipingType() == ShipingType.Outcome) {
            executeOutcomeGoodsDocument(document);
        } else if (document.getShipingType() == ShipingType.Inventory) {
            executeInventoryGoodsDocument(document);
        }
    }

    private void executeIncomeGoodsDocument(GoodsDocument document) {
        GoodsPackResource goodsPackResource = GoodsPackResource.getInstance();
        for (GoodsPackWithPrice goodsPack: document.getGoods().getList()) {
            goodsPackResource.saveOrUpdate(new GoodsPack(goodsPack, document));
        }
        document.setDocumentState(DocumentState.Executed);
        GoodsDocumentResource.getInstance().saveOrUpdate(document);
    }

    private void executeOutcomeGoodsDocument(GoodsDocument document) {
        GoodsPackResource goodsPackResource = GoodsPackResource.getInstance();
        for (GoodsPackWithPrice goodsPack: document.getGoods().getList()) {
            GoodsPack packOnStock = goodsPackResource.getById(goodsPack.getId());
            int amountOnStock = packOnStock.getAmount();
            if (amountOnStock < goodsPack.getAmount()) {
                throw new RuntimeException("Not enought amount for pack with id " + packOnStock.getId());
            }
            packOnStock.setAmount(amountOnStock - goodsPack.getAmount());
            goodsPackResource.saveOrUpdate(packOnStock);
        }
        document.setDocumentState(DocumentState.Executed);
        GoodsDocumentResource.getInstance().saveOrUpdate(document);
    }

    private void executeInventoryGoodsDocument(GoodsDocument document) {
        GoodsPackResource goodsPackResource = GoodsPackResource.getInstance();
        for (GoodsPackWithPrice goodsPack: document.getGoods().getList()) {
            GoodsPack packOnStock = goodsPackResource.getById(goodsPack.getId());
            packOnStock.setAmount(goodsPack.getAmount());
            goodsPackResource.saveOrUpdate(packOnStock);
        }
        document.setDocumentState(DocumentState.Executed);
        GoodsDocumentResource.getInstance().saveOrUpdate(document);
    }
}
