package org.warranty.user_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Account_id")
    private Integer id;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "email_id")
    private String email;

    @NotNull

    @Column(name = "user_id", unique = true)
    private String userId;
    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "creation_date")
    private LocalDateTime creationDateTime;

    @NotNull
    @Column(name = "expiration_date")
    private LocalDateTime expirationDateTime;


    @NotNull
    @Column(name = "is_Active")
    private boolean isActive;

    @NotNull
    @Column(name = "region")
    private String region;

    @NotNull
    @Column(name = "contact")
    private Long contactNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "role_id")
    private Role role;
}
