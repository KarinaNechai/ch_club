package com.charakhovich.club.model.entity;

import java.time.LocalDateTime;

public class Ticket extends Entity {
    private long id;
    private Event event;
    private User user;
    private TicketStatus status;
    private LocalDateTime date;
    private TicketType ticketType;
    private int cost;

    public Ticket(Event event, User user, LocalDateTime date) {
        this.event = event;
        this.user = user;
        this.status=TicketStatus.NEW;
        this.date = date;
    }

    public Ticket() {
    }

    public Ticket(long id, Event event, User user, TicketStatus status, LocalDateTime date) {
        this.id = id;
        this.event = event;
        this.user = user;
        this.status = status;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return getId() == ticket.getId() &&
                getEvent().equals(ticket.getEvent()) &&
                getUser().equals(ticket.getUser()) ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result=result * prime+Long.hashCode(id);
        result=result * prime+ event.hashCode();
        result=result * prime+user.hashCode();
        return result ;
    }

    @Override
    public String toString() {
        StringBuilder strResult = new StringBuilder("Ticket ");
        strResult.append("{id=").append(id).append(';');
        strResult.append(" flight=").append(event.toString()).append(';');
        strResult.append(" user=").append(user.toString()).append('}');
        return strResult.toString();
    }
}
