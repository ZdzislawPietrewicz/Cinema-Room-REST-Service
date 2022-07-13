package cinema;

import cinema.errors.RowOrColumnOutOfBounds;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CinemaController {
    private List<Seat> available_seats = new ArrayList<>();
    Cinema cinema = new Cinema();

    public CinemaController() {
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
    public Seat purchaseTicket(@RequestBody Seat seat) {
        if (seat.getRow() > cinema.getTotal_rows() || seat.getColumn() > cinema.getTotal_columns()) {
            throw new RowOrColumnOutOfBounds("The number of a row or a column is out of bounds!");
        }
        for (Seat available_seat : cinema.getAvailable_seats()) {
            if (available_seat.getColumn() == seat.getColumn() && available_seat.getRow() == seat.getRow()) {
                cinema.getAvailable_seats().remove(available_seat);
                return available_seat;
            }
        }
       return null;

    }
}



