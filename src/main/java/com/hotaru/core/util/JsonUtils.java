package com.hotaru.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class JsonUtils {
    public static <Type> Type parse(String json, Class<Type> cl) throws IOException {
        if (json == null) {
            return null;
        }
        StringReader reader = new StringReader(json);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(reader, cl);
    }

    public static <Type> String stringify(Type object) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, object);
        return writer.toString();
    }
}
