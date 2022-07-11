package cinema;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class CinemaController {


    @GetMapping("/seats")
    public Cinema getSeats() {
        Cinema cinema = new Cinema();
        List<Seat> available_seats = new ArrayList<>();
        for (int i = 0; i < cinema.getTotal_rows(); i++) {
            for (int j = 0; j < cinema.getTotal_columns(); j++) {
                available_seats.add(new Seat(i + 1, j + 1));
            }
        }
        cinema.setAvailable_seats(available_seats);
        return cinema;
    }

}



