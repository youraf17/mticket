package com.accedo.mticket.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity @Table(
        name = "ticket",
        uniqueConstraints = @UniqueConstraint(name = "uk_ticket_serial", columnNames = "serialNumber"),
        indexes = {
                @Index(name = "idx_ticket_user", columnList = "user_id"),
                @Index(name = "idx_ticket_order", columnList = "order_id"),
                @Index(name = "idx_ticket_status", columnList = "status")
        }
)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Ticket extends AbstractAuditable {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserAccount user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Lob
    @Column(nullable = false)
    private String jwsCompact; // JWS signé encodé

    @Column(length = 64, nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private Instant validFrom;

    @Column(nullable = false)
    private Instant validTo;

    @Enumerated(EnumType.STRING)
    @Column(length = 16, nullable = false)
    private TicketStatus status = TicketStatus.ACTIVE;

    @Column(nullable = false)
    private Instant issuedAt;
}