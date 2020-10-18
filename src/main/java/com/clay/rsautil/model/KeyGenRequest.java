package com.clay.rsautil.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractAuditable;
import java.math.BigInteger;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KeyGenRequest extends AbstractAuditable<String, BigInteger> {

    @JsonProperty(value = "id")
    private BigInteger id;

    @JsonProperty(value = "algorithm")
    private String algorithm;

    @JsonProperty(value = "key_size")
    private Integer keySize;
}
