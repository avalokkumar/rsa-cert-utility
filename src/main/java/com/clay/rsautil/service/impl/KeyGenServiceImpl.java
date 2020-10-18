package com.clay.rsautil.service.impl;

import com.clay.rsautil.entity.KeyGenData;
import com.clay.rsautil.exception.KeyPairGenerationFailedException;
import com.clay.rsautil.exception.KeysNotFoundException;
import com.clay.rsautil.mapper.KeyGenMapper;
import com.clay.rsautil.model.KeyGenRequest;
import com.clay.rsautil.model.KeyGenResponse;
import com.clay.rsautil.repository.KeyGenDataRepository;
import com.clay.rsautil.service.KeyGenService;
import com.clay.rsautil.service.KeyPairGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Base64;
import java.util.List;

@Service
public class KeyGenServiceImpl implements KeyGenService {

    @Autowired
    private KeyGenMapper keyGenMapper;

    @Autowired
    private KeyPairGeneratorService keyPairGeneratorService;

    @Autowired
    private KeyGenDataRepository keyGenDataRepository;

    @Override
    public List<KeyGenResponse> getAllKeys() {
        return keyGenMapper.entityToModel(keyGenDataRepository.findAll());
    }

    @Override
    public KeyGenResponse getKeyById(BigInteger id) throws KeysNotFoundException {
        KeyGenData keyGenData = keyGenDataRepository.findById(id).orElseThrow(() -> new KeysNotFoundException("Keys Not present for given ID"));

        return keyGenMapper.entityToModel(keyGenData);
    }

    @Override
    public KeyGenResponse createKeys(KeyGenRequest keyGenRequest) throws KeyPairGenerationFailedException {
        KeyPair keyPair;
        try {
            keyPair = keyPairGeneratorService.getKeyPair(keyGenRequest.getAlgorithm(), keyGenRequest.getKeySize());
        } catch (NoSuchProviderException | NoSuchAlgorithmException e) {
            throw new KeyPairGenerationFailedException("Failed to Generate KeyPair " + e.getMessage());
        }
        KeyGenResponse keyGenResponse = buildKeyGenResponse(keyGenRequest.getAlgorithm(), keyGenRequest.getKeySize(), keyPair);
        keyGenDataRepository.save(keyGenMapper.modelToEntity(keyGenResponse));

        return keyGenResponse;
    }

    private KeyGenResponse buildKeyGenResponse(String algorithm, int keySize, KeyPair keyPair) {
        return KeyGenResponse.builder()
        .algorithm(algorithm)
        .keySize(keySize)
        .publicKey(toBase64(keyPair.getPublic().getEncoded()))
        .privateKey(toBase64(keyPair.getPrivate().getEncoded()))
                .build();
    }

    @Override
    public void deleteKeyById(BigInteger id) throws KeysNotFoundException {
        KeyGenData keyGenData = keyGenDataRepository.findById(id)
                .orElseThrow(() -> new KeysNotFoundException("Keys Not present for given ID"));
        keyGenDataRepository.delete(keyGenData);
    }

    private String toBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }
}
