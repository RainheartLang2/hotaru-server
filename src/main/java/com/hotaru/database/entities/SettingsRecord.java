package com.hotaru.database.entities;

import com.hotaru.core.database.Identifiable;

import javax.persistence.*;

@Table(name="settings")
@Entity(name="settings")
public class SettingsRecord implements Identifiable {
    public static String UNIT_PRICE_KEY;
    public static String DELIVERY_PRICE_KEY;
    public static String MINIMAL_DELIVERY_COST;
    public static String MINIMAL_DELIVERY_AMOUNT;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="settingKey", unique = true)
    private String key;

    @Column(name="value")
    private String value;

    public SettingsRecord() {}

    public SettingsRecord(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
