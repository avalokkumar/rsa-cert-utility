package com.clay.rsautil.service;



import com.clay.rsautil.exception.DigitalCertNotFoundException;
import com.clay.rsautil.model.DigitalCertRequest;
import com.clay.rsautil.model.DigitalCertResponse;

import java.math.BigInteger;
import java.security.cert.CertificateEncodingException;
import java.util.List;

public interface DigitalCertGenService {

    List<DigitalCertResponse> getAllDigitalCert();

    DigitalCertResponse getDigitalCertById(BigInteger id) throws DigitalCertNotFoundException;

    DigitalCertResponse createDigitalCertificate(DigitalCertRequest certRequest);

    void deleteDigitalCertById(BigInteger id) throws DigitalCertNotFoundException;
}
