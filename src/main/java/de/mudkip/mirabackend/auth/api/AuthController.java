package de.mudkip.mirabackend.auth.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/register")
    public String register() {
        return "Hello from Mira Register! :)";
    }

}
