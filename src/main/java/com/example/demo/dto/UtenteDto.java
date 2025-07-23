package com.example.demo.dto;

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
