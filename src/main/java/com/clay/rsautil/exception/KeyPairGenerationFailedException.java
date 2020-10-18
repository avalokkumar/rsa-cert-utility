package com.clay.rsautil.exception;

public class KeyPairGenerationFailedException extends Exception{

    public KeyPairGenerationFailedException() {
        super();
    }

    public KeyPairGenerationFailedException(String message) {
        super(message);
    }
}
