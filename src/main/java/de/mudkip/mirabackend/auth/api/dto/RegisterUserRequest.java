package de.mudkip.mirabackend.auth.api.dto;

import de.mudkip.mirabackend.user.domain.AccountType;

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