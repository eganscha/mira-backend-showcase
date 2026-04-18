package de.mudkip.mirabackend.security.domain;

public enum Permission {
    CAN_CHAT("Allows chat usage"),
    CAN_CREATE_LISTING("Allows listing creation"),
    CAN_CREATE_ELECTRICIAN_LISTING("Allows electrician listing creation"),
    CAN_MODERATE_REPORTS("Allows report moderation");

    private final String description;

    Permission(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
