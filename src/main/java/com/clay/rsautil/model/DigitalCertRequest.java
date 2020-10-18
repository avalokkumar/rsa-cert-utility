package com.clay.rsautil.model;

import com.clay.rsautil.util.SignatureAlgorithm;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DigitalCertRequest {

    @JsonProperty(value = "algorithm")
    private String algorithm;

    @JsonProperty(value = "signature_algorithm")
    private SignatureAlgorithm signatureAlgorithm;

    @JsonProperty(value = "key_size")
    private Integer keySize;

    @JsonProperty(value = "common_name")
    private String commonName;

    @JsonProperty(value = "certificate_expiry_months")
    private Integer certificateExpiryMonths;

}
