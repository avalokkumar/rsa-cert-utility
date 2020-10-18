package com.clay.rsautil.service;

import com.clay.rsautil.exception.KeyPairGenerationFailedException;
import com.clay.rsautil.exception.KeysNotFoundException;
import com.clay.rsautil.model.KeyGenRequest;
import com.clay.rsautil.model.KeyGenResponse;

import java.math.BigInteger;
import java.util.List;

public interface KeyGenService {

    List<KeyGenResponse> getAllKeys();

    KeyGenResponse getKeyById(BigInteger id) throws KeysNotFoundException;

    KeyGenResponse createKeys(KeyGenRequest keyGenRequest) throws KeyPairGenerationFailedException;

    void deleteKeyById(BigInteger id) throws KeysNotFoundException;
}
