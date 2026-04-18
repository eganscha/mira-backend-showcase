package de.mudkip.mirabackend.user.domain.credential.mapping;

import de.mudkip.mirabackend.user.domain.User;
import de.mudkip.mirabackend.user.domain.credential.Credential;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_credentials")
public class UserCredential {

    @EmbeddedId
    private UserCredentialId id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId("credentialName")
    @JoinColumn(name = "credential_name", referencedColumnName = "name", nullable = false)
    private Credential credential;

    @Column(nullable = false)
    private LocalDateTime grantedAt;

    private LocalDateTime expiresAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CredentialStatus status;

    protected UserCredential() {
    }

    public UserCredential(
            User user,
            Credential credential,
            LocalDateTime grantedAt,
            LocalDateTime expiresAt,
            CredentialStatus status
    ) {
        this.user = user;
        this.credential = credential;
        this.grantedAt = grantedAt;
        this.expiresAt = expiresAt;
        this.status = status;
        this.id = new UserCredentialId(
                user.getId(),
                credential.getName().name()
        );
    }

    public UserCredentialId getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Credential getCredential() {
        return credential;
    }

    public LocalDateTime getGrantedAt() {
        return grantedAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public CredentialStatus getStatus() {
        return status;
    }
}