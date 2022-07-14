package cinema.controller;

import cinema.errors.RowOrColumnOutOfBounds;
import cinema.errors.TicketAlreadyPurchased;
import cinema.errors.WrongPasswordException;
import cinema.errors.WrongToken;
import cinema.model.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class CinemaController {
    private List<Seat> available_seats = new ArrayList<>();
    private List<Ticket> reservedTickets = new ArrayList<>();
    Cinema cinema;
    public CinemaController() {
        cinema=new Cinema();
        for (int i = 0; i < cinema.getTotal_rows(); i++) {
            for (int j = 0; j < cinema.getTotal_columns(); j++) {
                available_seats.add(new Seat(i + 1, j + 1));

            }
        }
        cinema.setAvailable_seats(available_seats);
    }

    @GetMapping("/seats")
    public Cinema getSeats() {
        return cinema;
    }

    @PostMapping("/purchase")
    public Ticket purchaseTicket(@RequestBody Seat seat) {
        if (seat.getRow() > cinema.getTotal_rows() || seat.getColumn() > cinema.getTotal_columns() || seat.getColumn() <= 0 || seat.getRow() <= 0) {
            throw new RowOrColumnOutOfBounds("The number of a row or a column is out of bounds!");
        }
        for (Seat reservedSeat : cinema.getAvailable_seats()) {
            if (reservedSeat.getColumn() == seat.getColumn() && reservedSeat.getRow() == seat.getRow()) {
                cinema.getAvailable_seats().remove(reservedSeat);
                Ticket ticket = new Ticket(reservedSeat);
                reservedTickets.add(ticket);
                return ticket;
            }
        }
        throw new TicketAlreadyPurchased("The ticket has been already purchased!");

    }

    @PostMapping("/return")
    public ReturnTicket returnTicket(@RequestBody Ticket ticket) {
        for (Ticket reservedTicket : reservedTickets) {
            if (reservedTicket.getToken().equals(ticket.getToken())) {
                reservedTickets.remove(reservedTicket);
                available_seats.add(new Seat(reservedTicket.getTicket().getRow(), reservedTicket.getTicket().getColumn()));
                ReturnTicket returned_ticket = new ReturnTicket(new Seat(reservedTicket.getTicket().getRow(), reservedTicket.getTicket().getColumn()));
                return returned_ticket;
            }
        }
        throw new WrongToken("Wrong token!");
    }
    @PostMapping("/stats")
    public Stats showStatistics(@RequestParam(required = false)  String password ){
        if("super_secret".equals(password)){
            Stats stats = new Stats(reservedTickets);
            return stats;
        }
        throw new WrongPasswordException("The password is wrong!");
    }
}



