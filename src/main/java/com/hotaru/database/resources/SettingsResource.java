package com.hotaru.database.resources;

import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.SettingsRecord;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class SettingsResource extends ResourceBase<SettingsRecord> {
    private static SettingsResource INSTANCE = new SettingsResource();

    public static SettingsResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SettingsResource();
        }
        return INSTANCE;
    }
    
    private SettingsResource() {}

    public SettingsRecord getRecordByKey(String key) {
        List<SettingsRecord> records = getSession().
                createCriteria(SettingsRecord.class)
                .add(Restrictions.eq("key", key))
                .list();
        if (records.size() == 0) {
            return null;
        }

        return records.get(0);
    }

    public String getValueByKey(String key) {
        SettingsRecord record = getRecordByKey(key);
        if (record == null) {
            return null;
        }

        return record.getValue();
    }

    public void setSetting(String key, String value) {
        SettingsRecord record = getRecordByKey(key);
        if (record == null) {
            record = new SettingsRecord(key, value);
        } else {
            record.setValue(value);
        }
        saveOrUpdate(record);
    }
}
