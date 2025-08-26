package com.accedo.mticket.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "product")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Product extends AbstractAuditable {

    @Column(length = 80, nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean active = true;
}
