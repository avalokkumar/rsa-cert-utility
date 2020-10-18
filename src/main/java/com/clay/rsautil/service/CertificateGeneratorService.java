package com.clay.rsautil.service;

import com.clay.rsautil.model.DigitalCertRequest;

import java.security.cert.X509Certificate;

public interface CertificateGeneratorService {

    X509Certificate getX509Certificate(DigitalCertRequest certRequest);
}
