package com.clay.rsautil.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/security/certificate")
public class X509CertGenController {

    @GetMapping
    public ResponseEntity<Map<String, String>> getCertificate() {

        return ResponseEntity.ok().body(new HashMap<>());
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> generateDigitalCertificate() {

        return ResponseEntity.ok().body(new HashMap<>());
    }

    @DeleteMapping
    public ResponseEntity<Void> removeDigitalCertificate() {

        return ResponseEntity.noContent().build();
    }

}
