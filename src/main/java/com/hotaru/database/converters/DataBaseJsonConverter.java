package com.hotaru.database.converters;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public abstract class DataBaseJsonConverter<Type> implements AttributeConverter<Type, String> {

    @Override
    public String convertToDatabaseColumn(Type type) {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(writer, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }

    @Override
    public Type convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        StringReader reader = new StringReader(s);

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(reader, getEntityClass());
        } catch (IOException e) {
            return null;
        }
    }

    protected abstract Class<Type> getEntityClass();
}
