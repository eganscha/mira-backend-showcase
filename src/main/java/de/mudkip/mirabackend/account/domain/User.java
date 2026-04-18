package de.mudkip.mirabackend.account.domain;

import de.mudkip.mirabackend.account.domain.credential.mapping.UserCredential;
import de.mudkip.mirabackend.auth.domain.permission.Permission;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private boolean emailVerified = false;

    @Column(nullable = false)
    private boolean accountNonLocked = true;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private AccountType accountType;

    @Column(nullable = false)
    private LocalDate birthdate;

    @ElementCollection
    @CollectionTable(
            name = "user_direct_permissions",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "permission", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Permission> directPermissions = new HashSet<>();

    @ElementCollection
    @CollectionTable(
            name = "user_accessibility_preferences",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "preference", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<AccessibilityPreference> accessibilityPreferences = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserCredential> userCredentials = new HashSet<>();

    protected User() {
    }

    public User(
            String username,
            String email,
            String password,
            String firstName,
            String lastName,
            AccountType accountType,
            LocalDate birthdate
    ) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountType = accountType;
        this.birthdate = birthdate;
    }

    public UUID getId() {
        return id;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Set<AccessibilityPreference> getAccessibilityPreferences() {
        return Collections.unmodifiableSet(accessibilityPreferences);
    }

    public Set<UserCredential> getUserCredentials() {
        return Collections.unmodifiableSet(userCredentials);
    }

    public Set<Permission> getPermissions() {
        // Later: Calculate Permissions based on Credentials and E-Mail verification status
        return Collections.unmodifiableSet(directPermissions);
    }
}
