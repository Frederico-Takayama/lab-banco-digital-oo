package exception;

public class NegativeValueException extends Exception {
    public NegativeValueException() {
        super("Invalid value, negative value provided");
    }
}
