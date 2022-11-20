package com.igor.nvpc.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.igor.nvpc.exceptions.JsonException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConverterJsonTo {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T object(final String message, Class<T> klass) {
        try {
            return objectMapper.readValue(message, klass);
        } catch (final JsonProcessingException e) {
            log.error("Error convert json: {}", e.getMessage());
            throw new JsonException(e.getMessage());
        }
    }

    public static <T> T list(final String message, TypeReference<T> klass) {
        try {
            return objectMapper.readValue(message, klass);
        } catch (final JsonProcessingException e) {
            log.error("Error convert json: {}", e.getMessage());
            throw new JsonException(e.getMessage());
        }
    }
}
