package de.mudkip.mirabackend.auth.api.dto;

import de.mudkip.mirabackend.user.domain.AccountType;
import de.mudkip.mirabackend.user.domain.User;

import java.time.LocalDate;
import java.util.UUID;

public record RegisteredUserResponse(
        UUID id,
        String username,
        String email,
        String firstName,
        String lastName,
        AccountType accountType,
        LocalDate birthdate,
        boolean emailVerified
) {
    public RegisteredUserResponse(User user) {
        this(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getAccountType(),
                user.getBirthdate(),
                user.isEmailVerified()
        );
    }
}
