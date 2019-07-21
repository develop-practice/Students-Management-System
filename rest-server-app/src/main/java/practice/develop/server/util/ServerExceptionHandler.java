package practice.develop.server.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import practice.develop.server.model.dto.ErrorResponseBody;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ServerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
    	
    	ServerValidationErrorResponse error = new ServerValidationErrorResponse("validation error");
        ex.getConstraintViolations().forEach(v -> error.addValidationMessage(v.getMessage()));
        return super.handleExceptionInternal(ex, error, null, HttpStatus.BAD_REQUEST, request);
    }
    
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (!(body instanceof ErrorResponseBody)) {
            body = new ErrorResponseBody(status.getReasonPhrase(), "", "");
        }
        return new ResponseEntity<>(body, headers, status);
    }

}
