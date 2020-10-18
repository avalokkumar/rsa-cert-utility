package com.clay.rsautil.service.impl;

import com.clay.rsautil.model.DigitalCertRequest;
import com.clay.rsautil.service.CertificateGeneratorService;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;

@Slf4j
@Service
public class SelfSignedCertificateGeneratorService implements CertificateGeneratorService {

    @Autowired
    private RSAKeyPairGeneratorService keyPairGeneratorService;

    public X509Certificate getX509Certificate(DigitalCertRequest certRequest) {

        BouncyCastleProvider provider = new BouncyCastleProvider();
        try {
            KeyPair keyPair = keyPairGeneratorService.getKeyPair(
                    certRequest.getAlgorithm(),
                    certRequest.getKeySize()
            );
            if (ObjectUtils.isEmpty(keyPair.getPublic()) || ObjectUtils.isEmpty(keyPair.getPrivate())) {
                return null;
            }
            SubjectPublicKeyInfo publicKeyInfo = SubjectPublicKeyInfo.getInstance(keyPair.getPublic().getEncoded());
            ContentSigner signer = new JcaContentSignerBuilder(certRequest.getSignatureAlgorithm().getName())
                    .setProvider(provider)
                    .build(keyPair.getPrivate());

            Date startDate = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.MONTH, certRequest.getCertificateExpiryMonths());
            Date endDate = calendar.getTime();
            X500Name x500Name = new X500Name("cn=" + certRequest.getCommonName());
            X509v3CertificateBuilder certBuilder = new X509v3CertificateBuilder(
                    x500Name,
                    BigInteger.ONE,
                    startDate,
                    endDate,
                    x500Name,
                    publicKeyInfo
            );

            X509CertificateHolder certificateHolder = certBuilder.build(signer);
            return new JcaX509CertificateConverter().setProvider(provider).getCertificate(certificateHolder);
        } catch (NoSuchAlgorithmException | CertificateException | OperatorCreationException | NoSuchProviderException e) {
            log.error("label=KeyPairGeneratorUtil.generateCertificate : Error in generating X509Certificate {}", e.getMessage());
        }

        return null;
    }


}
