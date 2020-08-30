package com.hotaru.rpc.setting;

import com.hotaru.business.logic.Settings;
import com.hotaru.business.logic.objects.Price;
import com.hotaru.business.managers.SettingsManager;

import java.io.IOException;
import java.util.List;

public class UserSettingService {
    private class InitialSettings {
        private int price;
        private List<Price> localDeliveryPrices;
        private List<Price> regionDeliveryPrices;

        public InitialSettings(int price, List<Price> localDeliveryPrices, List<Price> regionDeliveryPrices) {
            this.price = price;
            this.localDeliveryPrices = localDeliveryPrices;
            this.regionDeliveryPrices = regionDeliveryPrices;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public List<Price> getLocalDeliveryPrices() {
            return localDeliveryPrices;
        }

        public void setLocalDeliveryPrices(List<Price> localDeliveryPrices) {
            this.localDeliveryPrices = localDeliveryPrices;
        }

        public List<Price> getRegionDeliveryPrices() {
            return regionDeliveryPrices;
        }

        public void setRegionDeliveryPrices(List<Price> regionDeliveryPrices) {
            this.regionDeliveryPrices = regionDeliveryPrices;
        }
    }

    public int getPrice() {
        return SettingsManager.getInstance().getUnitPrice();
    }

    public List<Price> getLocalDeliveryPrices() throws IOException {
        return SettingsManager.getInstance().getPriceSettings(Settings.LOCAL_DELIVERY_PRICES);
    }

    public List<Price> getRegionDeliveryPrices() throws IOException {
        return SettingsManager.getInstance().getPriceSettings(Settings.REGION_DELIVERY_PRICES);
    }

    public InitialSettings getInitialSettings() throws IOException {
        return new InitialSettings(
                getPrice(),
                getLocalDeliveryPrices(),
                getRegionDeliveryPrices()
        );
    }
}
