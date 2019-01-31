package com.vijeth.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JsonDateDeserializer extends JsonDeserializer <LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        return LocalDateTime.parse(jp.readValueAs(String.class), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}