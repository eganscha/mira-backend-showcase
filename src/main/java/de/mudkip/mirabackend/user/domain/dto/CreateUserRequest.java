package de.mudkip.mirabackend.user.domain.dto;

import de.mudkip.mirabackend.user.domain.AccountType;

import java.time.LocalDate;

public record CreateUserRequest(
        String username,
        String email,
        String rawPassword,
        String firstName,
        String lastName,
        AccountType accountType,
        LocalDate birthdate
) {
}