package pl.pmierkowski.bookssearch.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.pmierkowski.bookssearch.model.ErrorResponse;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class BooksSearchAdvice {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleMissingArgumentException(ConstraintViolationException exception) {
        return new ResponseEntity<>(
                new ErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        exception.getMessage(),
                        "Check your input fields"
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> handleMissingArgumentException(MissingServletRequestParameterException exception) {
        return new ResponseEntity<>(
                new ErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        String.format("Required parameter '%s' is missing", exception.getParameterName()),
                        String.format("You need to provide '%s' parameter '%s'", exception.getParameterType(), exception.getParameterName())
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception exception) {
        return new ResponseEntity<>(
                new ErrorResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        exception.getMessage(),
                        "Internal issue, try again later."
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
