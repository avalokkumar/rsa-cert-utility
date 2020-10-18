package com.clay.rsautil.service.impl;

import com.clay.rsautil.entity.DigitalCertData;
import com.clay.rsautil.exception.DigitalCertNotFoundException;
import com.clay.rsautil.mapper.DigitalCertResponseMapper;
import com.clay.rsautil.model.DigitalCertRequest;
import com.clay.rsautil.model.DigitalCertResponse;
import com.clay.rsautil.repository.DigitalCertRepository;
import com.clay.rsautil.service.CertificateGeneratorService;
import com.clay.rsautil.service.DigitalCertGenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.List;

@Slf4j
@Service
public class DigitalCertGenServiceImpl implements DigitalCertGenService {

    @Autowired
    private DigitalCertRepository digitalCertRepository;

    @Autowired
    private DigitalCertResponseMapper digitalCertResponseMapper;

    @Autowired
    private CertificateGeneratorService certificateGeneratorService;

    @Override
    public List<DigitalCertResponse> getAllDigitalCert() {
        return digitalCertResponseMapper.entityToModel(digitalCertRepository.findAll());
    }

    @Override
    public DigitalCertResponse getDigitalCertById(BigInteger id) throws DigitalCertNotFoundException {
        DigitalCertData digitalCertData = digitalCertRepository.findById(id)
                .orElseThrow(() -> new DigitalCertNotFoundException("Digital certificate not found for the given id "));
        return digitalCertResponseMapper.entityToModel(digitalCertData);
    }

    @Override
    public DigitalCertResponse createDigitalCertificate(DigitalCertRequest certRequest) {
        X509Certificate x509Certificate = certificateGeneratorService.getX509Certificate(certRequest);
        DigitalCertData digitalCertData = digitalCertRepository.save(buildDigitalCert(certRequest, x509Certificate));
        return digitalCertResponseMapper.entityToModel(digitalCertData);
    }

    @Override
    public void deleteDigitalCertById(BigInteger id) throws DigitalCertNotFoundException {
        DigitalCertData digitalCertData = digitalCertRepository.findById(id)
                .orElseThrow(() -> new DigitalCertNotFoundException("Digital certificate not found for the given id "));
        digitalCertRepository.delete(digitalCertData);
    }

    private DigitalCertData buildDigitalCert(DigitalCertRequest certRequest, X509Certificate x509Certificate) {
        DigitalCertData digitalCertData = new DigitalCertData();
        try {
            if (null != x509Certificate) {
                digitalCertData.setX509Certificate(toBase64(x509Certificate.getEncoded()));
            }
        } catch (CertificateEncodingException e) {
            log.info("label=DigitalCertGenServiceImpl.buildDigitalCert : Error while retrieving encoded certificate");
        }
        digitalCertData.setCertificateExpiryMonths(certRequest.getCertificateExpiryMonths());
        digitalCertData.setCommonName(certRequest.getCommonName());
        digitalCertData.setAlgorithm(certRequest.getAlgorithm());
        digitalCertData.setSignatureAlgorithm(certRequest.getSignatureAlgorithm().getName());
        return digitalCertData;
    }


    private String toBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }
}
