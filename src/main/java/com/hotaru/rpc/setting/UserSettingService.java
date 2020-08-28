package com.hotaru.rpc.setting;

import com.hotaru.business.logic.Settings;
import com.hotaru.business.managers.SettingsManager;

public class UserSettingService {
    private class InitialSettings {
        private int price;
        private int deliveryPrice;
        private int minimalDeliveryCost;
        private int minimalDeliveryAmount;

        public InitialSettings(int price, int deliveryPrice, int minimalDeliveryCost, int getMinimalDeliveryAmount) {
            this.price = price;
            this.deliveryPrice = deliveryPrice;
            this.minimalDeliveryCost = minimalDeliveryCost;
            this.minimalDeliveryAmount = getMinimalDeliveryAmount;
        }

        public int getPrice() {
            return price;
        }

        public int getDeliveryPrice() {
            return deliveryPrice;
        }

        public int getMinimalDeliveryCost() {
            return minimalDeliveryCost;
        }

        public int getMinimalDeliveryAmount() {
            return minimalDeliveryAmount;
        }
    }

    public int getPrice() {
        return SettingsManager.getInstance().getIntegerSettings(Settings.UNIT_PRICE);
    }

    public int getDeliveryPrice() {
        return SettingsManager.getInstance().getIntegerSettings(Settings.DELIVERY_PRICE);
    }

    public int getMinimalDeliveryCost() {
        return SettingsManager.getInstance().getIntegerSettings(Settings.MINIMAL_DELIVERY_COST);
    }

    public int getMinimalDeliveryAmount() {
        return SettingsManager.getInstance().getIntegerSettings(Settings.MINIMAL_DELIVERY_AMOUNT);
    }

    public InitialSettings getInitialSettings() {
        return new InitialSettings(
                getPrice(),
                getDeliveryPrice(),
                getMinimalDeliveryCost(),
                getMinimalDeliveryAmount()
        );
    }
}
