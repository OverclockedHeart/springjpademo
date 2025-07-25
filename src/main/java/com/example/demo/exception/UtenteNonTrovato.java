package com.example.demo.exception;

public class UtenteNonTrovato extends RuntimeException {

    public UtenteNonTrovato(Long id) {
        super("Utente con ID " + id + " non trovato");

    }
}
