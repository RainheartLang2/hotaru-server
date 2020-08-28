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
        return SettingsManager.getInstance().getPrice();
    }

    public int getDeliveryPrice() {
        return SettingsManager.getInstance().getDeliveryPrice();
    }

    public int getMinimalDeliveryCost() {
        return SettingsManager.getInstance().getMinimalDeliveryCost();
    }

    public int getMinimalDeliveryAmount() {
        return SettingsManager.getInstance().getMinimalDeliveryAmount();
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
