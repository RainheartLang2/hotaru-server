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
        if (document.getDocumentState() == null) {
            document.setDocumentState(DocumentState.Saved);
        }
        GoodsDocumentResource.getInstance().saveOrUpdate(document);
        if (execute) {
            execute(document);
        }
    }

    public void cancel(GoodsDocument document) {
        if (document.getShipingType() == ShipingType.Transfer) {
            cancelTransfer(document);
        } else {
            document.setDocumentState(DocumentState.Canceled);
            GoodsDocumentResource.getInstance().saveOrUpdate(document);
        }
    }

    public void execute(GoodsDocument document) {
        if (document.getShipingType() == ShipingType.Income) {
            executeIncomeGoodsDocument(document);
        } else if (document.getShipingType() == ShipingType.Outcome) {
            executeOutcomeGoodsDocument(document);
        } else if (document.getShipingType() == ShipingType.Inventory) {
            executeInventoryGoodsDocument(document);
        } else if (document.getShipingType() == ShipingType.Transfer) {
            executeTransfer(document);
        }
    }

    private void addGoodsForStock(GoodsDocument document, int stockId) {
        GoodsPackResource goodsPackResource = GoodsPackResource.getInstance();
        for (GoodsPackWithPrice goodsPack: document.getGoods().getList()) {
            goodsPackResource.saveOrUpdate(new GoodsPack(goodsPack, document, stockId));
        }
    }

    private void executeIncomeGoodsDocument(GoodsDocument document) {
        addGoodsForStock(document, document.getStockId());
        document.setDocumentState(DocumentState.Executed);
        GoodsDocumentResource.getInstance().saveOrUpdate(document);
    }

    private void executeOutcomeGoodsDocument(GoodsDocument document) {
        removeGoodsByDocument(document);
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

    private void removeGoodsByDocument(GoodsDocument document) {
        GoodsPackResource goodsPackResource = GoodsPackResource.getInstance();
        for (GoodsPackWithPrice goodsPack: document.getGoods().getList()) {
            GoodsPack packOnStock = goodsPackResource.getById(goodsPack.getId());
            int amountOnStock = packOnStock.getAmount();
            if (amountOnStock < goodsPack.getAmount()) {
                throw new RuntimeException("Not enough amount for pack with id " + packOnStock.getId());
            }
            packOnStock.setAmount(amountOnStock - goodsPack.getAmount());
            goodsPackResource.saveOrUpdate(packOnStock);
        }
    }

    private void executeTransfer(GoodsDocument document) {
        if (document.getDocumentState() == DocumentState.Saved) {
            sentTransfer(document);
        } else if (document.getDocumentState() == DocumentState.Sent) {
            acceptTransfer(document);
        }
    }

    private void sentTransfer(GoodsDocument document) {
        removeGoodsByDocument(document);
        document.setDocumentState(DocumentState.Sent);
        GoodsDocumentResource.getInstance().saveOrUpdate(document);
    }

    private void acceptTransfer(GoodsDocument document) {
        addGoodsForStock(document, document.getDestinationStockId());
        document.setDocumentState(DocumentState.Executed);
        GoodsDocumentResource.getInstance().saveOrUpdate(document);
    }

    private void cancelTransfer(GoodsDocument document) {
        GoodsPackResource goodsPackResource = GoodsPackResource.getInstance();
        if (document.getDocumentState() == DocumentState.Sent) {
            for (GoodsPackWithPrice pack: document.getGoods().getList()) {
                GoodsPack packOnSourceStock = goodsPackResource.getById(pack.getId());
                packOnSourceStock.setAmount(packOnSourceStock.getAmount() + pack.getAmount());
                goodsPackResource.saveOrUpdate(packOnSourceStock);
            }
        }
        document.setDocumentState(DocumentState.Canceled);
        GoodsDocumentResource.getInstance().saveOrUpdate(document);
    }
}
