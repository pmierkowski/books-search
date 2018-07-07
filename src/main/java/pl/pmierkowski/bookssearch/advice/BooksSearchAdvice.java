package pl.pmierkowski.bookssearch.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.pmierkowski.bookssearch.model.ErrorResponse;

@ControllerAdvice
public class BooksSearchAdvice {

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
