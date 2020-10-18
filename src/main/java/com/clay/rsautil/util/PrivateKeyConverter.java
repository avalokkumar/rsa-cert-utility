package com.clay.rsautil.util;

import com.clay.rsautil.entity.PrivateKey;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.PersistenceException;
import java.io.IOException;

@Slf4j
public class PrivateKeyConverter implements AttributeConverter<PrivateKey, String>  {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    PrivateKeyConverter() {
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.setVisibility(PropertyAccessor.CREATOR, JsonAutoDetect.Visibility.ANY);
    }
    @Override
    public String convertToDatabaseColumn(PrivateKey privateKey) {
        try {
            if (privateKey == null)
                return null;
            return objectMapper.writeValueAsString(privateKey);
        } catch (JsonProcessingException e) {
            log.error("Invalid private key ",e);
            throw new PersistenceException("Invalid private key");
        }
    }

    @Override
    public PrivateKey convertToEntityAttribute(String privateKeyStr) {
        try {
            if (privateKeyStr == null)
                return null;

            return objectMapper.readValue(privateKeyStr, PrivateKey.class);
        } catch (IOException e) {
            log.error("Invalid private key ",e);
            throw new PersistenceException("Invalid private key");
        }
    }
}
