package com.accedo.mticket.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "city",
        uniqueConstraints = @UniqueConstraint(name = "uk_city_code", columnNames = "code"),
        indexes = @Index(name = "idx_city_name", columnList = "name")
)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class City extends AbstractAuditable {

    @Column(length = 3, nullable = false)
    private String code;

    @Column(length = 80, nullable = false)
    private String name;
}