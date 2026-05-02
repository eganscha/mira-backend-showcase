package de.mudkip.mirabackend.security;

import de.mudkip.mirabackend.domain.user.User;
import de.mudkip.mirabackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Primary
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
