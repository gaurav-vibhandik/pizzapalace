package com.myapp.exception;

import com.myapp.dto.ErrorResponseDto;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex , WebRequest request){

        Map<String, String> errorMap =  new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError ->{
            errorMap.put(fieldError.getField() , fieldError.getDefaultMessage());
        });
        ErrorResponseDto fresp = new ErrorResponseDto();
        fresp.setSuccess(false);
        fresp.setMessage("error occured while creating");
        fresp.setError(new CustomErrorWithMap(HttpStatus.BAD_REQUEST.value(),errorMap) );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fresp);
    }

    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleJsonParseException(HttpMessageNotReadableException e){
        ErrorResponseDto fresp = new ErrorResponseDto();
        fresp.setSuccess(false);
        fresp.setMessage(e.getMessage());
        fresp.setError(new CustomError(HttpStatus.BAD_REQUEST.value(),e.getMessage()));

        return new ResponseEntity<>(fresp,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?>handleCustomException(CustomException ex, WebRequest request) {
        ErrorResponseDto fresp = new ErrorResponseDto();
        fresp.setSuccess(false);
        fresp.setMessage(ex.getDtoErrorMessage());
        fresp.setError(new CustomError(ex.getErrorStatus().value(),ex.getMessage()));

        return new ResponseEntity<>(fresp,ex.getErrorStatus());
    }


}
