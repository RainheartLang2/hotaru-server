package com.hotaru.database.converters;

import com.hotaru.core.util.JsonUtils;

import javax.persistence.AttributeConverter;
import java.io.IOException;

public abstract class DataBaseJsonConverter<Type> implements AttributeConverter<Type, String> {

    @Override
    public String convertToDatabaseColumn(Type type) {
        try {
            return JsonUtils.stringify(type);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public Type convertToEntityAttribute(String s) {
        try {
            return JsonUtils.parse(s, getEntityClass());
        } catch (IOException e) {
            return null;
        }
    }

    protected abstract Class<Type> getEntityClass();
}
