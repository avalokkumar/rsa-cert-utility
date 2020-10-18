package com.clay.rsautil.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DigitalCertResponse {

    private BigInteger id;

    @JsonProperty(value = "x509certificate")
    private String x509Certificate;

    @JsonProperty(value = "signature_algorithm")
    private String signatureAlgorithm;

    @JsonProperty(value = "common_name")
    private String commonName;

    @JsonProperty(value = "certificate_expiry_months")
    private Integer certificateExpiryMonths;
}
