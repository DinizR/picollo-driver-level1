/*
* ResourceExceptionHandler.java
 */
package org.picollo.resource.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

/*
* Generic exception handling for REST APIs.
* @author rod
* @since 2019-03-25
 */
@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value=ItemNotFoundException.class)
    public ResponseEntity<ExceptionResponse> notFoundException(ItemNotFoundException exception, WebRequest request) {
        return new ResponseEntity(new ExceptionResponse(LocalDateTime.now(),exception.getMessage(),request.getDescription(false)),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value=GeneralException.class)
    public ResponseEntity<ExceptionResponse> InternalException(GeneralException exception, WebRequest request) {
        return new ResponseEntity(new ExceptionResponse(LocalDateTime.now(),exception.getMessage(),request.getDescription(false)),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value=BadRequestException.class)
    public ResponseEntity<ExceptionResponse> InternalException(BadRequestException exception, WebRequest request) {
        return new ResponseEntity(new ExceptionResponse(LocalDateTime.now(),exception.getMessage(),request.getDescription(false)),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value=NotImplementedException.class)
    public ResponseEntity<ExceptionResponse> InternalException(NotImplementedException exception, WebRequest request) {
        return new ResponseEntity(new ExceptionResponse(LocalDateTime.now(),exception.getMessage(),request.getDescription(false)),HttpStatus.NOT_IMPLEMENTED);
    }
}