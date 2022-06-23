package com.santander.ejercicio_excepciones.exceptions;

import com.santander.ejercicio_excepciones.dtos.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GeneralExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleValidationExceptions(MethodArgumentNotValidException e) {
        return new ErrorDto(
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "Validation error",
                e.getBindingResult().getAllErrors().stream().map(
                        error -> Map.of(
                                "code", ((FieldError) error).getField(),
                                "message", error.getDefaultMessage()
                        )
                ).collect(Collectors.toList())
        );
    }

    @ExceptionHandler({
            UserAlreadyRegisteredException.class
            // ...
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleBadRequestExceptions(RuntimeException e) {
        return new ErrorDto(HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleNotExpectedExceptions(RuntimeException e) {
        log.error(e.getMessage());
        return new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "Oops algo salió mal");
    }

}
