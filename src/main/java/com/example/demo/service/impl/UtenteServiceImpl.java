package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UtenteNonTrovato;
import com.example.demo.model.Ruolo;
import com.example.demo.model.Utente;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.service.UtenteService;

@Service
public class UtenteServiceImpl implements UtenteService {

    @Autowired
    UtenteRepository utenteRepository;

    @Override
    public Utente creaUtente(Utente utente) {

        if(utente.getFkRuolo() == null) {
            
            Ruolo ruolo = new Ruolo();

            ruolo.setId(1L);
            utente.setFkRuolo(ruolo); 

        }

        return utenteRepository.save(utente);
    }

    @Override
    public Utente getUtente(Long id){

        return utenteRepository.findById(id).orElseThrow(() -> new UtenteNonTrovato(id));
    }

    @Override
    public Utente putUtente(Long id, Utente utente) {

        if (utenteRepository.existsById(id)) {
            utente.setId(id);
            
            return utenteRepository.save(utente);
        }

        return null;
    }

    @Override
    public Utente cancellaUtente(Long id) {
        if(utenteRepository.existsById(id)){
            Utente utente = utenteRepository.findById(id).orElse(null);
            
            utenteRepository.deleteById(id);
            
            return utente;
        }
        else {
        
            return null;
        }
    }
}