package com.hotaru.rpc.setting;

import com.hotaru.database.entities.SettingsRecord;
import com.hotaru.database.resources.SettingsResource;

public class UserSettingService {
    public int getPrice() {
        String value = SettingsResource.getInstance().getValueByKey(SettingsRecord.UNIT_PRICE_KEY);
        return Integer.parseInt(value);
    }

    public int getDeliveryPrice() {
        String value = SettingsResource.getInstance().getValueByKey(SettingsRecord.DELIVERY_PRICE_KEY);
        return Integer.parseInt(value);
    }

    public int getMinimalDeliveryCost() {
        String value = SettingsResource.getInstance().getValueByKey(SettingsRecord.MINIMAL_DELIVERY_COST);
        return Integer.parseInt(value);
    }

    public int getMinimalDeliveryAmount() {
        String value = SettingsResource.getInstance().getValueByKey(SettingsRecord.MINIMAL_DELIVERY_COST);
        return Integer.parseInt(value);
    }
}
