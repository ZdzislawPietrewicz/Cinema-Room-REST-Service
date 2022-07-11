package cinema;

import java.util.List;

public class Cinema {
    private final int total_rows = 9;
    private final int total_columns = 9;
    private List<Seat> available_seats;

    public Cinema() {
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public List<Seat> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(List<Seat> available_seats) {
        this.available_seats = available_seats;
    }
}

