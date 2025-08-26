package com.accedo.mticket.repository;

import com.accedo.mticket.domain.PaymentCmi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentCmiRepository extends JpaRepository<PaymentCmi, UUID> {
}
