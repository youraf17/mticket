package com.accedo.mticket.repository;

import com.accedo.mticket.domain.SigningKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SigningKeyRepository extends JpaRepository<SigningKey, UUID> {
}
