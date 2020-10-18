package com.clay.rsautil.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "key_gen_data")
public class KeyGenData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @Column(name = "algorithm")
    private String algorithm;

    @Column(name = "key_size")
    private Integer keySize;

    @Column(name = "public_key")
    private String publicKey;

    @Lob
    @Column(name = "private_key", columnDefinition="TEXT")
    private String privateKey;
}
