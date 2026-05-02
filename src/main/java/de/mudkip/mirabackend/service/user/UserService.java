package de.mudkip.mirabackend.service.user;

import de.mudkip.mirabackend.domain.user.User;
import de.mudkip.mirabackend.repository.UserRepository;
import de.mudkip.mirabackend.dto.auth.RegisterUserRequest;
import de.mudkip.mirabackend.service.user.exception.EmailAlreadyExistsException;
import de.mudkip.mirabackend.service.user.exception.UsernameAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    return new UsernameNotFoundException("User not found: " + username);
                });
    }

    public User createUser(RegisterUserRequest request) {
        if (userRepository.existsByUsername(request.username())) {
            throw new UsernameAlreadyExistsException("Username already exists: " + request.username());
        }

        if (userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistsException("Email already exists: " + request.email());
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
