package com.charakhovich.club.model.entity;

import java.time.LocalDateTime;

public class Event extends Entity {
    private long eventId;
    private EventType eventType;
    private String name;
    private String description;
    private String shortDescription;
    private String namePicture;
    private int countTickets;
    private boolean isActual;
    private LocalDateTime modifyDate;

    public Event() {

        this.isActual=true;
    }

    public Event(int eventId, EventType eventType, String name, String description, String namePicture,
                 int countTickets, boolean isActual,String shortDescription) {
        this.eventId = eventId;
        this.eventType = eventType;
        this.name = name;
        this.description = description;
        this.namePicture = namePicture;
        this.countTickets = countTickets;
        this.isActual = isActual;
        this.shortDescription=shortDescription;
    }
    public Event(EventType eventType, String name, String description, String namePicture, int countTickets,
                 boolean isActual,String shortDescription) {
        this.eventType = eventType;
        this.name = name;
        this.description = description;
        this.namePicture = namePicture;
        this.countTickets = countTickets;
        this.isActual = isActual;
        this.shortDescription=shortDescription;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNamePicture() {
        return namePicture;
    }

    public void setNamePicture(String namePicture) {
        this.namePicture = namePicture;
    }

    public int getCountTickets() {
        return countTickets;
    }

    public void setCountTickets(int countTickets) {
        this.countTickets = countTickets;
    }

    public boolean isActual() {
        return isActual;
    }

    public void setActual(boolean actual) {
        isActual = actual;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
