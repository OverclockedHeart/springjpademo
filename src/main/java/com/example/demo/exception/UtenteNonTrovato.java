package com.example.demo.exception;

import com.example.demo.model.Ruolo;

public class UtenteNonTrovato extends RuntimeException {

    public UtenteNonTrovato(Long id) {
        super("Utente con ID " + id + " non trovato");

    }
}
