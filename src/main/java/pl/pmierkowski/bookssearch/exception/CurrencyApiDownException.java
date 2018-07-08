package pl.pmierkowski.bookssearch.exception;

public class CurrencyApiDownException extends RuntimeException {
    public CurrencyApiDownException() {
        super("Currency API id down");
    }
}
