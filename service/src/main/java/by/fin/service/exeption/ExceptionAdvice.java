package by.fin.service.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<SingleErrorResponse> processingException (IllegalStateException i){
        SingleErrorResponse response = new SingleErrorResponse();
        response.setLogref("error");
        response.setMessage(i.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
