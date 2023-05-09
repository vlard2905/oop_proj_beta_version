package app.oop_proj.custom_exceptions;
import java.io.Serial;
public class TooManyVariables extends Exception { // Custom exception.
    @Serial
    private static final long serialVersionUID = -3121055327488048910L;
    public TooManyVariables() {
        super("So many varibles...");
    }
}

