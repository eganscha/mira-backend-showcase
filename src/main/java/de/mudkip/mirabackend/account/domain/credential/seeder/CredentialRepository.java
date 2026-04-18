package de.mudkip.mirabackend.account.domain.credential.seeder;

import de.mudkip.mirabackend.account.domain.credential.Credential;
import de.mudkip.mirabackend.account.domain.credential.CredentialType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<Credential, CredentialType> {
}