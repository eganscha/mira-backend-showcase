package de.mudkip.mirabackend.user.service;

import de.mudkip.mirabackend.user.domain.User;
import de.mudkip.mirabackend.user.domain.UserRepository;
import de.mudkip.mirabackend.user.domain.dto.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserManager {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserManager(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    return new UsernameNotFoundException("User not found: " + username);
                });
    }

    public User createUser(CreateUserRequest request) {
        if (userRepository.existsByUsername(request.username())) {
            throw new IllegalArgumentException("Username already exists: " + request.username());
        }

        if (userRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Email already exists: " + request.email());
        }

        User userToSave = new User(
                request.username(),
                request.email(),
                passwordEncoder.encode(request.rawPassword()),
                request.firstName(),
                request.lastName(),
                request.accountType(),
                request.birthdate()
        );

        return userRepository.save(userToSave);
    }

    public void updateUser(User user) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void deleteUser(String username) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void changePassword(String oldPassword, String newPassword) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean userExists(String username) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
