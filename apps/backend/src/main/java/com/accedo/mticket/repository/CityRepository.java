package com.accedo.mticket.repository;
import com.accedo.mticket.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CityRepository extends JpaRepository<City, UUID> {
    Optional<City> findByCodeIgnoreCase(String code);
    boolean existsByCodeIgnoreCase(String code);
    List<City> findAllByOrderByNameAsc();
}