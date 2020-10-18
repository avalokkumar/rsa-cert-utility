package com.clay.rsautil.rest;

import com.clay.rsautil.exception.DigitalCertNotFoundException;
import com.clay.rsautil.model.DigitalCertRequest;
import com.clay.rsautil.model.DigitalCertResponse;
import com.clay.rsautil.service.DigitalCertGenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/security/certificate")
public class X509CertGenController {

    @Autowired
    private DigitalCertGenService digitalCertGenService;

    @GetMapping
    public ResponseEntity<List<DigitalCertResponse>> getAllCertificates() {

        return ResponseEntity.ok().body(digitalCertGenService.getAllDigitalCert());
    }


    @GetMapping("/{id}")
    public ResponseEntity<DigitalCertResponse> getAllCertificates(@PathVariable BigInteger id) throws DigitalCertNotFoundException {

        return ResponseEntity.ok().body(digitalCertGenService.getDigitalCertById(id));
    }

    @PostMapping
    public ResponseEntity<DigitalCertResponse> generateDigitalCertificate(@RequestBody DigitalCertRequest digitalCertRequest) {

        return ResponseEntity.ok().body(digitalCertGenService.createDigitalCertificate(digitalCertRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeDigitalCertificate(@PathVariable BigInteger id) throws DigitalCertNotFoundException {
        digitalCertGenService.deleteDigitalCertById(id);
        return ResponseEntity.noContent().build();
    }

}
