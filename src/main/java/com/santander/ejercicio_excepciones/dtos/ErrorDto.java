package com.santander.ejercicio_excepciones.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDto {

    private String code;
    private String message;
    private List<Map<String, String>> errors;

    public ErrorDto(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
