package de.mudkip.mirabackend.auth.security.user;

import de.mudkip.mirabackend.account.domain.User;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class SecurityUser implements UserDetails {

    private final User user;

    public SecurityUser(User user) {
        this.user = user;
    }

    @Override
    @NonNull
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    @NonNull
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    @NonNull
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .toList();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isAccountNonLocked();
    }
}