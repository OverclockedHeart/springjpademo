package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UtenteDto {

    private Long id;
    
    public UtenteDto() {}

    public UtenteDto(Long id) {
        this.id = id;
    
    }

    //Getter
    public Long getId() {
     
        return id;
    }
    
    //Setter
    public void setId(Long id) {
        this.id = id;
    
    }
}
