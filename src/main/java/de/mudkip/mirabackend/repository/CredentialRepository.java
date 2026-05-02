package de.mudkip.mirabackend.repository;

import de.mudkip.mirabackend.domain.credential.Credential;
import de.mudkip.mirabackend.domain.credential.CredentialType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<Credential, CredentialType> {
}