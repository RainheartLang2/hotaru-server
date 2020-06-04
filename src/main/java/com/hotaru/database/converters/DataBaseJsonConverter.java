package com.hotaru.database.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotaru.core.entities.WorkSchedule;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.ParameterizedType;

public class DataBaseJsonConverter<Type> implements AttributeConverter<Type, String> {

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
        StringReader reader = new StringReader(s);
        Class<Type> cl = ((Class) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(reader, cl);
        } catch (IOException e) {
            return null;
        }
    }
}
