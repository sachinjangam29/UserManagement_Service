package org.warranty.user_service.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.warranty.user_service.model.Role;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String userId;

    @NotNull
    private String password;

    @NotNull
    private LocalDateTime creationDateTime;

    @NotNull
    private LocalDateTime expirationDateTime;


    @NotNull
    @JsonProperty("isActive")
    private boolean active;

    @NotNull
    private String region;

    @NotNull
    private Long contactNumber;

    private Role role;
}
