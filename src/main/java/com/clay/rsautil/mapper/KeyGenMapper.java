package com.clay.rsautil.mapper;
import com.clay.rsautil.entity.KeyGenData;
import com.clay.rsautil.entity.PrivateKey;
import com.clay.rsautil.model.KeyGenResponse;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class KeyGenMapper {

    public KeyGenResponse entityToModel(com.clay.rsautil.entity.KeyGenData keyGenData) {
        return KeyGenResponse.builder()
                .id(keyGenData.getId())
                .algorithm(keyGenData.getAlgorithm())
                .keySize(keyGenData.getKeySize())
                .publicKey(keyGenData.getPublicKey())
                .privateKey(keyGenData.getPrivateKey())
                .build();
    }

    public com.clay.rsautil.entity.KeyGenData modelToEntity(final KeyGenResponse keyGenResponse) {
        KeyGenData keyGenData = new KeyGenData();
        keyGenData.setId(keyGenResponse.getId());
        keyGenData.setAlgorithm(keyGenResponse.getAlgorithm());
        keyGenData.setKeySize(keyGenResponse.getKeySize());
        keyGenData.setPublicKey(keyGenResponse.getPublicKey());
        keyGenData.setPrivateKey(keyGenResponse.getPrivateKey());

        return keyGenData;
    }

    public List<KeyGenResponse> entityToModel(List<com.clay.rsautil.entity.KeyGenData> keyGenList) {

        return keyGenList.stream()
                .map(this::entityToModel)
                .collect(toList());
    }

    public List<com.clay.rsautil.entity.KeyGenData> modelToEntity(List<KeyGenResponse> keyGenResponseList) {
        return keyGenResponseList.stream()
                .map(this::modelToEntity)
                .collect(toList());
    }
}
