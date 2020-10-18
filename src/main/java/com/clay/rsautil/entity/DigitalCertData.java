package com.clay.rsautil.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "self_signed_cert")
public class DigitalCertData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @Lob
    @Column(name = "x509certificate", columnDefinition="TEXT")
    private String x509Certificate;

    @Column(name = "algorithm")
    private String algorithm;

    @Column(name = "signature_algorithm")
    private String signatureAlgorithm;

    @Column(name = "common_name")
    private String commonName;

    @Column(name = "certificate_expiry_months")
    private Integer certificateExpiryMonths;
}
