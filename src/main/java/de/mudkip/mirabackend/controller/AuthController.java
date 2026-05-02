package de.mudkip.mirabackend.controller;

import de.mudkip.mirabackend.dto.auth.RegisterUserRequest;
import de.mudkip.mirabackend.dto.auth.RegisteredUserResponse;
import de.mudkip.mirabackend.domain.user.User;
import de.mudkip.mirabackend.service.user.UserService;
import de.mudkip.mirabackend.service.user.exception.EmailAlreadyExistsException;
import de.mudkip.mirabackend.service.user.exception.UsernameAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    UserService userService;
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest request) {
        log.debug("Received request to register user.");

        try {
            User createdUser = userService.createUser(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(new RegisteredUserResponse(createdUser));
        } catch (UsernameAlreadyExistsException | EmailAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
