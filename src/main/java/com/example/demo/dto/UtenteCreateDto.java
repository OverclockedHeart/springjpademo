package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class UtenteCreateDto {

    @NotBlank(message = "Il nome non può essere vuoto")
    private String nome;

    @NotBlank(message = "Il cognome non può essere vuoto")
    private String cognome;
    
}

