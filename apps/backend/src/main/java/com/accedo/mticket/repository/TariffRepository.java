package com.accedo.mticket.repository;

import com.accedo.mticket.domain.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TariffRepository extends JpaRepository<Tariff, UUID> {
}
