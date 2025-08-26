package com.accedo.mticket.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity @Table(name = "payment_cmi")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class PaymentCmi extends AbstractAuditable {

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", nullable = false, unique = true)
    private Payment payment;

    @Column(columnDefinition = "jsonb")
    private String requestParams; // snapshot des champs envoyés

    @Column(length = 16)
    private String responseCode;

    @Column(nullable = false)
    private boolean signatureValid = false;

    @Lob
    private String ipnRaw; // IPN brut (pour forensic)

    private Instant ipnReceivedAt;
}