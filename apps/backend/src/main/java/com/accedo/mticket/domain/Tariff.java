package com.accedo.mticket.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity @Table(
        name = "tariff",
        indexes = {
                @Index(name = "idx_tariff_city_prod", columnList = "city_id,product_id"),
                @Index(name = "idx_tariff_active", columnList = "active")
        }
)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Tariff extends AbstractAuditable {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal price;   // MAD implicite au niveau métier

    private LocalDate startDate; // null = dès maintenant
    private LocalDate endDate;   // null = sans fin

    @Column(nullable = false)
    private boolean active = true;
}
