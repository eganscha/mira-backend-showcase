package de.mudkip.mirabackend.user.domain.credential.seeder;

import de.mudkip.mirabackend.user.domain.credential.Credential;
import de.mudkip.mirabackend.user.domain.credential.CredentialType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<Credential, CredentialType> {
}