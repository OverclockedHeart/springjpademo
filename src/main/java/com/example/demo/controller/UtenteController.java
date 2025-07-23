package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UtenteCreateDto;
import com.example.demo.dto.UtenteDto;
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

    @GetMapping("/utente/{id}")
    public ResponseEntity<UtenteDto> getUtente(@PathVariable Long id) {

        Utente utente = utenteService.getUtente(id);
        UtenteDto dto = new UtenteDto();

        if (utente == null) {

            return ResponseEntity.notFound().build(); 
        }

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/utente")
    public ResponseEntity<Utente> creaUtente(@RequestBody UtenteCreateDto utente) {

        Utente entita = new Utente();
        
        entita.setNome(utente.getNome());
        entita.setCognome(utente.getCognome());

        return ResponseEntity.ok(utenteService.creaUtente(entita));
    }

    @PutMapping("utente/{id}")
    public ResponseEntity<Utente> putUtente(@PathVariable Long id, @RequestBody UtenteCreateDto utente) {

        Utente entita = new Utente();

        entita.setNome(utente.getNome());
        entita.setCognome(utente.getCognome());

        return ResponseEntity.ok(utenteService.putUtente(id, entita));
    }

    @DeleteMapping("utente/{id}")
    public void deleteUtente(@PathVariable Long id) {
        utenteService.cancellaUtente(id);

    }
}
