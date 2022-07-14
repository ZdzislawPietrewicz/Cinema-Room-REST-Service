package cinema.model;

import java.util.List;

public class Stats {
    private int current_income;
    private int number_of_available_seats;
    private int number_of_purchased_tickets;

    public Stats(List<Ticket>purchasedTickets) {
        Cinema cinema = new Cinema();
        number_of_purchased_tickets=0;
        number_of_available_seats=cinema.getTotal_columns()*cinema.getTotal_rows();
        for (Ticket purchasedTicket : purchasedTickets) {
            number_of_available_seats--;
            number_of_purchased_tickets++;
            Seat seat = new Seat(purchasedTicket.getTicket().getRow(),purchasedTicket.getTicket().getColumn());
            current_income+=seat.getPrice();
        }
    }

    public Stats() {

    }

    public int getCurrent_income() {
        return current_income;
    }

    public void setCurrent_income(int current_income) {
        this.current_income = current_income;
    }

    public int getNumber_of_available_seats() {
        return number_of_available_seats;
    }

    public void setNumber_of_available_seats(int number_of_available_seats) {
        this.number_of_available_seats = number_of_available_seats;
    }

    public int getNumber_of_purchased_tickets() {
        return number_of_purchased_tickets;
    }

    public void setNumber_of_purchased_tickets(int number_of_purchased_tickets) {
        this.number_of_purchased_tickets = number_of_purchased_tickets;
    }
}
