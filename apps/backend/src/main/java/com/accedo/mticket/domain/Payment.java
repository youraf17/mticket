package com.accedo.mticket.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity @Table(
        name = "payment",
        indexes = @Index(name = "idx_payment_order", columnList = "order_id")
)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Payment extends AbstractAuditable {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Enumerated(EnumType.STRING)
    @Column(length = 8, nullable = false)
    private PaymentMethod method = PaymentMethod.CMI;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(length = 16, nullable = false)
    private PaymentStatus status = PaymentStatus.INITIATED;

    @Column(length = 120)
    private String providerRef; // référence côté CMI (PAYID...etc)

    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private PaymentCmi cmi;
}