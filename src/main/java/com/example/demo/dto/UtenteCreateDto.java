package com.example.demo.dto;

public class UtenteCreateDto {

    private String nome;
    private String cognome;
    
    public UtenteCreateDto() {}

    public UtenteCreateDto(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;

    }

    //Getter
    public String getNome() {
   
        return nome;
    }
    
    public String getCognome() {
        
        return cognome;
    }

    //Setter
    public void setNome(String nome) {
        this.nome = nome;

    }

    public void setCognome(String cognome) {
        this.cognome = cognome;

    }
}

