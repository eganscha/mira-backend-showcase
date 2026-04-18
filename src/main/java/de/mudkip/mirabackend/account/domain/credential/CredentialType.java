package de.mudkip.mirabackend.account.domain.credential;

public enum CredentialType {

    STUDENT_VERIFIED("Student status has been verified"),
    IDENTITY_VERIFIED("User identity has been verified"),
    MASTER_PLUMBER("User holds a master plumber qualification");

    private final String description;

    CredentialType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
