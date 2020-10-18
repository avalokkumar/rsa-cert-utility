package com.clay.rsautil.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KeyGenResponse {

    private BigInteger id;

    @Column(name = "algorithm")
    private String algorithm;

    @Column(name = "key_size")
    private Integer keySize;

    @Column(name = "public_key")
    private String publicKey;

    @Column(name = "encrypted_private_key")
    private String privateKey;

}
