package de.mudkip.mirabackend.auth.security.authentication.provider;

import de.mudkip.mirabackend.auth.security.user.SecurityUser;
import de.mudkip.mirabackend.user.domain.User;
import de.mudkip.mirabackend.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // Load user from DB
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    return new UsernameNotFoundException("User not found: " + username);
                });
        // Return UserDetails implementation with GrantedAuthority for permissions
        return new SecurityUser(user);
    }
}
