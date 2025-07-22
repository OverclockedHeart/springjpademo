package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Utente;
import com.example.demo.service.UtenteService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

//test

@RestController
@RequestMapping("/api")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @PostMapping("/utente")
    public Utente creaUtente(@RequestBody Utente utente) {

        return utenteService.creaUtente(utente);
    }

    @GetMapping("/utente/{id}")
    public Utente getUtente(@PathVariable Long id) {

        Utente utente = utenteService.getUtente(id);

        return utente;
    }

    @PutMapping("utente/{id}")
    public Utente putUtente(@PathVariable Long id, @RequestBody Utente utente) {

        Utente entita = utenteService.putUtente(id, utente);

        return entita;
    }

    @DeleteMapping("utente/{id}")
    public void deleteUtente(@PathVariable Long id) {
        utenteService.cancellaUtente(id);

    }
}
