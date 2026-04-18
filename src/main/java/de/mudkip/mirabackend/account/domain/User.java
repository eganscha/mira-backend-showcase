package de.mudkip.mirabackend.account.domain;

import de.mudkip.mirabackend.auth.domain.permission.Permission;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userUUID;

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

    @Column(nullable = false)
    private boolean enabled = true;

    @Column(nullable = false)
    private boolean accountNonLocked = true;

    @Column(nullable = false)
    private boolean accountNonExpired = true;

    @Column(nullable = false)
    private boolean credentialsNonExpired = true;

    @ElementCollection
    @CollectionTable(
            name = "user_direct_permissions",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "permission")
    @Enumerated(EnumType.STRING)
    private Set<Permission> directPermissions = new HashSet<>();

    protected User() {
    }

    public User(String username, String email, String password, String firstName, String lastName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getUserUUID() {
        return userUUID;
    }

    public String getUsername() {
        return username;
    }

    public void changeUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void changeEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String hashedPassword) {
        this.password = hashedPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void changeFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void changeLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void enable() {
        this.enabled = true;
    }

    public void disable() {
        this.enabled = false;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void lockAccount() {
        this.accountNonLocked = false;
    }

    public void unlockAccount() {
        this.accountNonLocked = true;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void expireAccount() {
        this.accountNonExpired = false;
    }

    public void unexpireAccount() {
        this.accountNonExpired = true;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void expireCredentials() {
        this.credentialsNonExpired = false;
    }

    public void unexpireCredentials() {
        this.credentialsNonExpired = true;
    }

    public Set<Permission> getDirectPermissions() {
        return directPermissions;
    }

    public void grantDirectPermission(Permission permission) {
        this.directPermissions.add(permission);
    }

    public void revokeDirectPermission(Permission permission) {
        this.directPermissions.remove(permission);
    }

    public boolean hasDirectPermission(Permission permission) {
        return this.directPermissions.contains(permission);
    }
}
