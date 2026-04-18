package de.mudkip.mirabackend.user.domain.credential.seeder;

import de.mudkip.mirabackend.user.domain.credential.Credential;
import de.mudkip.mirabackend.user.domain.credential.CredentialType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CredentialSeeder implements CommandLineRunner {

    private final CredentialRepository credentialRepository;

    @Autowired
    public CredentialSeeder(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    @Override
    public void run(String... args) {
        for (CredentialType credentialType : CredentialType.values()) {
            if (!credentialRepository.existsById(credentialType)) {
                credentialRepository.save(new Credential(credentialType));
            }
        }
    }
}
