package cinema.errors;

public class RowOrColumnOutOfBounds extends RuntimeException{
    public RowOrColumnOutOfBounds(String message) {
        super(message);
    }
}
