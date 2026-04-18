package de.mudkip.mirabackend.account.domain.credential.mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class UserCredentialId implements Serializable {

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "credential_name", length = 50)
    private String credentialName;

    protected UserCredentialId() {
    }

    public UserCredentialId(UUID userId, String credentialName) {
        this.userId = userId;
        this.credentialName = credentialName;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getCredentialName() {
        return credentialName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCredentialId that)) return false;
        return Objects.equals(userId, that.userId) && Objects.equals(credentialName, that.credentialName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, credentialName);
    }
}