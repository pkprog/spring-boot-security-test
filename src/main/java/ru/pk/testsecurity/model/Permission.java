package ru.pk.testsecurity.model;

public enum Permission {
    DEVELOPERS_READ("dev:read"),
    DEVELOPERS_WRITE("dev:write");


    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
