package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class UtenteModDto {
    
    private Long identificativo;
    
    @NotBlank(message = "Il nome non può essere vuoto")
    private String nominativo;

    public UtenteModDto(){}

    public UtenteModDto(Long identificativo, String nominativo) {
        this.identificativo = identificativo;
        this.nominativo = nominativo;

    }

    //Getter
    public Long getIdentificativo() {
    
        return identificativo;
    }
    
    public String getNominativo() {
    
        return nominativo;
    }

    //Setter
    public void setIdentificativo(Long identificativo) {
        this.identificativo = identificativo;
    
    }
    
    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    
    }
}
