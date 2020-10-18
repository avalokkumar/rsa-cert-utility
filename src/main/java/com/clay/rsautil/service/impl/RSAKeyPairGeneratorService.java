package com.clay.rsautil.service.impl;

import com.clay.rsautil.service.KeyPairGeneratorService;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Service;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Service
public class RSAKeyPairGeneratorService implements KeyPairGeneratorService {

    @Override
    public KeyPair getKeyPair(String algorithm, int keySize) throws NoSuchProviderException, NoSuchAlgorithmException {
        Security.addProvider(new BouncyCastleProvider());
        SecureRandom random = new SecureRandom();
        random.setSeed(20);
        KeyPairGenerator rsaGenerator = KeyPairGenerator.getInstance(algorithm, "BC");
        rsaGenerator.initialize(keySize, random);
        KeyPair rsaPair = rsaGenerator.generateKeyPair();
        RSAPublicKey rsaPublicKey = (RSAPublicKey) rsaPair.getPublic();
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) rsaPair.getPrivate();
        return new KeyPair(rsaPublicKey, rsaPrivateKey);
    }
}
