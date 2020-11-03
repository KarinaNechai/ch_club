package com.charakhovich.club.model.entity;

public enum EntityStatus {
    ACTUAL(true),
    DELETED(false);
    boolean status;
    EntityStatus(boolean status) {
        this.status=status;
    }
    public boolean getStatus() {
        return status;
    }
}
