package com.hotaru.business.managers;

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
}
