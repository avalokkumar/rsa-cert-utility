package com.clay.rsautil.repository;

import com.clay.rsautil.entity.KeyGenData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface KeyGenDataRepository extends JpaRepository<KeyGenData, BigInteger> {
}
