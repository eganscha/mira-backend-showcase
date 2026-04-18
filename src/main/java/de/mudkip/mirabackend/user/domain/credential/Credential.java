package de.mudkip.mirabackend.user.domain.credential;

import jakarta.persistence.*;

@Entity
@Table(name = "credentials")
public class Credential {

    @Id
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private CredentialType name;

    @Column(nullable = false, length = 500)
    private String description;

    protected Credential() {
    }

    public Credential(CredentialType name) {
        this.name = name;
        this.description = name.getDescription();
    }

    public CredentialType getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}