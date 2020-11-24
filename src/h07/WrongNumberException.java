package h07;

/**
 * Wird geworfen wenn man eine falsche Zahl eingibt, die nicht zwischen 0 und 16 liegt.
 */
public class WrongNumberException extends RuntimeException {
    public WrongNumberException(String s) {
        super(s);
    }
}
