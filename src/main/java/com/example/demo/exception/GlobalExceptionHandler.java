package com.example.demo.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(UtenteNonTrovato.class)
    public ResponseEntity<String> UtenteNonTrovato(UtenteNonTrovato exption) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exption.getMessage());
    }

    @ExceptionHandler(RuoloNonTrovatoEx.class)
    public ResponseEntity<String> RuoloNonTrovato(RuoloNonTrovatoEx exption) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exption.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationEx>> handleException(MethodArgumentNotValidException exception) {

        List<ValidationEx> validation = exception.getBindingResult().getFieldErrors().stream().map(error -> 
        new ValidationEx(error.getField(), error.getDefaultMessage())).collect(Collectors.toList()); 

        return ResponseEntity.badRequest().body(validation);
    }
}
