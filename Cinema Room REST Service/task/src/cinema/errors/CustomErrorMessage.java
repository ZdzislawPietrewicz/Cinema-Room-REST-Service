package cinema.errors;

import java.util.HashMap;

public class CustomErrorMessage {
private String error;

    public CustomErrorMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
