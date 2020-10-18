package com.clay.rsautil.rest;

import com.clay.rsautil.exception.KeyPairGenerationFailedException;
import com.clay.rsautil.exception.KeysNotFoundException;
import com.clay.rsautil.model.KeyGenRequest;
import com.clay.rsautil.model.KeyGenResponse;
import com.clay.rsautil.service.KeyGenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/security/keys")
public class KeyGenController {

    @Autowired
    private KeyGenService keyGenService;

    @GetMapping
    public ResponseEntity<List<KeyGenResponse>> getAllKeys() {
        return ResponseEntity.ok().body(keyGenService.getAllKeys());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<KeyGenResponse> getKeyById(@PathVariable(name = "id") BigInteger id) throws KeysNotFoundException {

        return ResponseEntity.ok().body(keyGenService.getKeyById(id));
    }

    @PostMapping
    public ResponseEntity<KeyGenResponse> generateKeys(@RequestBody KeyGenRequest keyGenRequest) throws KeyPairGenerationFailedException {

        return ResponseEntity.ok().body(keyGenService.createKeys(keyGenRequest));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> removeRSAKeys(@PathVariable(name = "id") BigInteger id) throws KeysNotFoundException {
        keyGenService.deleteKeyById(id);
        return ResponseEntity.noContent().build();
    }
}
