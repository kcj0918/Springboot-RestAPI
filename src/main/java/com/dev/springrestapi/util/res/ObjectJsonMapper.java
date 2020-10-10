package com.dev.springrestapi.util.res;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectJsonMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String process(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
}
