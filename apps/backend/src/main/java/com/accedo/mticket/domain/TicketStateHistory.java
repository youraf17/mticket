package com.accedo.mticket.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity @Table(name = "ticket_state_history")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class TicketStateHistory extends AbstractAuditable {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @Column(length = 16, nullable = false)
    private String fromStatus;

    @Column(length = 16, nullable = false)
    private String toStatus;

    @Column(length = 120)
    private String reason;

    @Column(nullable = false)
    private Instant at;
}