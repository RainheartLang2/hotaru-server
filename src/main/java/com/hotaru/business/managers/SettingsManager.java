package com.hotaru.business.managers;

import com.hotaru.business.logic.Settings;
import com.hotaru.business.logic.objects.Price;
import com.hotaru.core.util.JsonUtils;
import com.hotaru.database.resources.SettingsResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SettingsManager {
    private static SettingsManager INSTANCE = new SettingsManager();

    public static SettingsManager getInstance() {
        return INSTANCE;
    }

    private SettingsManager() {}

    public boolean getBooleanSetting(String key) {
        String stringResult = SettingsResource.getInstance().getValueByKey(key);
        return Boolean.valueOf(stringResult);
    }

    public void setBooleanSetting(String key, boolean value) {
        SettingsResource.getInstance().setSetting(key, Boolean.toString(value));
    }

    public int getIntegerSettings(String key) {
        String stringResult = SettingsResource.getInstance().getValueByKey(key);
        return Integer.valueOf(stringResult);
    }

    public void setIntegerSetting(String key, int value) {
        SettingsResource.getInstance().setSetting(key, Integer.toString(value));
    }

    public List<Price> getPriceSettings(String key) throws IOException {
        String stringResult = SettingsResource.getInstance().getValueByKey(key);
        return JsonUtils.parse(stringResult, ArrayList.class);
    }

    public void setPriceSettings(String key, List<Price> prices) throws IOException {
        SettingsResource.getInstance().setSetting(key, JsonUtils.stringify(prices));
    }

    public int getUnitPrice() {
        return getIntegerSettings(Settings.UNIT_PRICE);
    }

    public int getSupplyPrice() {
        return getIntegerSettings(Settings.SUPPLY_PRICE);
    }
    public List<Price> getLocalDeliveryPrices() throws IOException {
        return getPriceSettings(Settings.LOCAL_DELIVERY_PRICES);
    }

    public List<Price> getRegionDeliveryPrices() throws IOException {
        return getPriceSettings(Settings.REGION_DELIVERY_PRICES);
    }
}
