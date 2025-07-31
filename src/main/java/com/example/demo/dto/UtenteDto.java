package com.example.demo.dto;

import com.example.demo.model.Ruolo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UtenteDto {

    private Long id;
    private RuoloDto fkRuolo;
    
}
