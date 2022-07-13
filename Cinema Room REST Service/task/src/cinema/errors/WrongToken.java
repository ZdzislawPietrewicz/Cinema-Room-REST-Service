package cinema.errors;

public class WrongToken extends RuntimeException{
    public WrongToken(String message) {
        super(message);
    }
}
