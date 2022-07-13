package cinema.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.*;

public class Ticket {
    private UUID token;
    private Seat ticket;

    public Ticket(Seat seat) {
        this.token= UUID.randomUUID();
        this.ticket=seat;
    }

    public Ticket() {
    }

    public Seat getTicket() {
        return ticket;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}
