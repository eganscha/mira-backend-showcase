package de.mudkip.mirabackend.dto.auth;

import de.mudkip.mirabackend.domain.user.AccountType;

import java.time.LocalDate;

public record RegisterUserRequest(
        String username,
        String email,
        String rawPassword,
        String firstName,
        String lastName,
        AccountType accountType,
        LocalDate birthdate
) {
}