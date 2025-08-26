package com.accedo.mticket.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity @Table(
        name = "signing_key",
        uniqueConstraints = @UniqueConstraint(name = "uk_signing_kid", columnNames = "kid")
)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SigningKey extends AbstractAuditable {

    @Column(length = 64, nullable = false)
    private String kid;

    @Column(length = 8, nullable = false)
    private String alg; // ES256/RS256

    @Lob
    @Column(nullable = false)
    private String jwkPublic;

    @Column(nullable = false)
    private boolean active = true;

    private Instant rotatedAt;
}