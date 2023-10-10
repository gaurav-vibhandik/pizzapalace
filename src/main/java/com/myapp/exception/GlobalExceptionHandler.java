package com.myapp.exception;

import com.myapp.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex , WebRequest request){

        Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

        ErrorResponseDto fresp = new ErrorResponseDto();
        fresp.setSuccess(false);
        fresp.setMessage("error occured while creating");
        fresp.setError(new CustomErrorWithMap(HttpStatus.BAD_REQUEST.value(),errors) );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fresp);
    }



    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?>handleCustomException(CustomException ex, WebRequest request) {
        ErrorResponseDto fresp = new ErrorResponseDto();
        fresp.setSuccess(false);
        fresp.setMessage(ex.getDtoErrorMessage());
        fresp.setError(new CustomError(ex.getErrorStatus().value(),ex.getMessage()));

        return new ResponseEntity<>(fresp,ex.getErrorStatus());
    }

    /*@ExceptionHandler(CustomExceptionList.class)
    public ResponseEntity<?>handleCustomExceptionList(CustomExceptionList ex, WebRequest request) {
        ErrorResponseDto fresp = new ErrorResponseDto();
        fresp.setSuccess(false);
        fresp.setMessage(ex.getDtoErrorMessage());
        fresp.setError(new CustomError(ex.getErrorStatus().value(),ex.getMessage()));

        return new ResponseEntity<>(fresp,ex.getErrorStatus());
    }*/

}
