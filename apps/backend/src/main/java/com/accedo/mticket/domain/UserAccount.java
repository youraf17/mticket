package com.accedo.mticket.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(
        name = "user_account",
        uniqueConstraints = @UniqueConstraint(name = "uk_user_auth_sub", columnNames = "authSubject")
)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserAccount extends AbstractAuditable {

    @Column(nullable = false, length = 190)
    private String authSubject; // sub Keycloak

    @Column(length = 190)
    private String email;

    @Column(length = 32)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(length = 16, nullable = false)
    private UserStatus status = UserStatus.ACTIVE;
}
