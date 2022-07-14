package cinema.errors;

import cinema.errors.CustomErrorMessage;
import cinema.errors.RowOrColumnOutOfBounds;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(RowOrColumnOutOfBounds.class)
    public ResponseEntity<CustomErrorMessage> handleRowOrColumnOutOfBound(
            RowOrColumnOutOfBounds e, WebRequest request) {
        CustomErrorMessage customErrorMessage = new CustomErrorMessage(e.getMessage());
        return new ResponseEntity<>(customErrorMessage, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TicketAlreadyPurchased.class)
    public ResponseEntity<CustomErrorMessage>handleTicketAlreadyPurchased(TicketAlreadyPurchased e, WebRequest request){
        CustomErrorMessage customErrorMessage = new CustomErrorMessage(e.getMessage());
        return new ResponseEntity<>(customErrorMessage, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(WrongToken.class)
    public ResponseEntity<CustomErrorMessage>handleWrongToken(WrongToken e){
        CustomErrorMessage customErrorMessage = new CustomErrorMessage(e.getMessage());
        return new ResponseEntity<>(customErrorMessage,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<CustomErrorMessage>handleWrongPassword(WrongPasswordException e){
        CustomErrorMessage customErrorMessage = new CustomErrorMessage(e.getMessage());
    return new ResponseEntity<>(customErrorMessage,HttpStatus.UNAUTHORIZED);
    }
}
