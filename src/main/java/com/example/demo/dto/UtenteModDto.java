package com.example.demo.dto;

import com.example.demo.model.Ruolo;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UtenteModDto {
    
    private Long identificativo;
    
    @NotBlank(message = "Il nome non può essere vuoto")
    private String nominativo;

    private RuoloDto idRuolo;
 
}
