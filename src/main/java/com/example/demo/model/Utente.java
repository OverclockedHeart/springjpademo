package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "utenti")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cognome;

    public Utente(Long id, String nome, String cognome) {

        this.id = id;
        this.nome = nome;
        this.cognome = cognome;

    }

    public Utente() {
    }

    // Getter
    public Long getId() {

        return id;
    }

    public String getNome() {

        return nome;
    }

    public String getCognome() {

        return cognome;
    }

    // Setter
    public void setId(Long id) {
        this.id = id;

    }

    public void setNome(String nome) {
        this.nome = nome;

    }

    public void setCognome(String cognome) {
        this.cognome = cognome;

    }

}
