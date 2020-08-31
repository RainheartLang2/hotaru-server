package com.hotaru.rpc.setting;

import com.hotaru.business.logic.Settings;
import com.hotaru.business.logic.objects.Price;
import com.hotaru.business.managers.SettingsManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminSettingService extends UserSettingService {
    public void update(int price, List<Price> localDeliveryPrices, List<Price> regionDeliveryPrices) throws IOException {
        SettingsManager settingsManager = SettingsManager.getInstance();
        settingsManager.setIntegerSetting(Settings.UNIT_PRICE, price);

        settingsManager.setPriceSettings(Settings.LOCAL_DELIVERY_PRICES, new ArrayList<Price>(localDeliveryPrices));
        settingsManager.setPriceSettings(Settings.REGION_DELIVERY_PRICES, regionDeliveryPrices);
    }
}
