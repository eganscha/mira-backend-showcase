package de.mudkip.mirabackend.auth.api;

import de.mudkip.mirabackend.auth.api.dto.RegisterUserRequest;
import de.mudkip.mirabackend.auth.api.dto.RegisteredUserResponse;
import de.mudkip.mirabackend.user.domain.User;
import de.mudkip.mirabackend.user.service.UserManager;
import de.mudkip.mirabackend.user.service.exception.EmailAlreadyExistsException;
import de.mudkip.mirabackend.user.service.exception.UsernameAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    UserManager userManager;
    private static final Logger log = LoggerFactory.getLogger(UserManager.class);

    public AuthController(UserManager userManager) {
        this.userManager = userManager;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest request) {
        log.debug("Received request to register user.");

        try {
            User createdUser = userManager.createUser(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(new RegisteredUserResponse(createdUser));
        } catch (UsernameAlreadyExistsException | EmailAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
