package app.oop_proj.controllers;
import java.io.Serial;
public class TooManyVeriables extends Exception {
    @Serial
    private static final long serialVersionUID = -3121055327488048910L;

    public TooManyVeriables(String message) {
        super(message);
    }
}

