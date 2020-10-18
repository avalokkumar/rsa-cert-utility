package com.clay.rsautil.service;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public interface KeyPairGeneratorService {

    KeyPair getKeyPair(String algorithm, int keySize) throws NoSuchProviderException, NoSuchAlgorithmException;
}
