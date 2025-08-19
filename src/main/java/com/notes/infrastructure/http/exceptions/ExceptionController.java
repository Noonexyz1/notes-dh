package com.notes.infrastructure.http.exceptions;

import com.notes.infrastructure.http.exceptions.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<ExceptionDTO> handlerException(RuntimeException exception) {
        ExceptionDTO build = ExceptionDTO.builder()
                .mensaje(exception.getMessage()).build();
        return new ResponseEntity<>(build, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
