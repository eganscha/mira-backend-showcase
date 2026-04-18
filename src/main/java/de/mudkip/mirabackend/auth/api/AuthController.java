package de.mudkip.mirabackend.auth.api;

import de.mudkip.mirabackend.auth.api.dto.RegisterUserRequest;
import de.mudkip.mirabackend.auth.api.dto.RegisteredUserResponse;
import de.mudkip.mirabackend.user.domain.User;
import de.mudkip.mirabackend.user.service.UserManager;
import de.mudkip.mirabackend.user.service.exception.EmailAlreadyExistsException;
import de.mudkip.mirabackend.user.service.exception.UsernameAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    UserManager userManager;

    public AuthController(UserManager userManager) {
        this.userManager = userManager;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest request) {
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
