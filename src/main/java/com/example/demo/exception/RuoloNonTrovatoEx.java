package com.example.demo.exception;

public class RuoloNonTrovatoEx extends RuntimeException {

    public RuoloNonTrovatoEx(Long id) {
        super("Ruolo con ID " + id + " non trovato");
    
    }    
}
