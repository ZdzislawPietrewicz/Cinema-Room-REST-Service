package cinema.errors;

public class TicketAlreadyPurchased extends RuntimeException{
    public TicketAlreadyPurchased(String message) {
        super(message);
    }
}
