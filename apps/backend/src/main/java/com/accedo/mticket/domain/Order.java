package com.accedo.mticket.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "orders") // 'order' est réservé SQL
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Order extends AbstractAuditable {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserAccount user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal totalAmount;

    @Column(length = 3, nullable = false)
    private String currency; // "MAD"

    @Enumerated(EnumType.STRING)
    @Column(length = 24, nullable = false)
    private OrderStatus status = OrderStatus.PENDING;

    @Column(length = 80)
    private String cmiReference; // ref côté CMI (optionnel)

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<OrderItem> items = new ArrayList<>();
}