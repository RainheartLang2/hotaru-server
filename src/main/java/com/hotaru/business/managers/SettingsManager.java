package com.hotaru.business.managers;

import com.hotaru.business.logic.Settings;
import com.hotaru.database.resources.SettingsResource;

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
}
