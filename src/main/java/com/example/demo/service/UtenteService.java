package com.example.demo.service;

import com.example.demo.model.Utente;

public interface UtenteService {
    Utente creaUtente(Utente utente);
    Utente getUtente(Long id);
    Utente putUtente(Long id, Utente utente);
    Utente cancellaUtente(Long id);

}
