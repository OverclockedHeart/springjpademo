package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UtenteDto;
import com.example.demo.mapper.UtenteMapper;
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
    public UtenteDto getUtente(@PathVariable Long id) {

        Utente utente = utenteService.getUtente(id);

        return UtenteMapper.utenteDto(utente);
    }

    @PostMapping("/utente")
    public UtenteDto creaUtente(@RequestBody UtenteDto utente) {

        Utente entita = UtenteMapper.utenteDtoToUtente(utente);
        Utente entitaSave = utenteService.creaUtente(entita);

        return UtenteMapper.utenteDto(entitaSave);
    }

    @PutMapping("utente/{id}")
    public ResponseEntity<UtenteDto> putUtente(@PathVariable Long id, @RequestBody UtenteDto utenteDto) {

        Utente entita = UtenteMapper.utenteDtoToUtente(utenteDto);
        Utente aggiornato = utenteService.putUtente(id, entita);

        if (aggiornato == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(UtenteMapper.utenteDto(aggiornato));
    }

    @DeleteMapping("utente/{id}")
    public void deleteUtente(@PathVariable Long id) {
        utenteService.cancellaUtente(id);

    }
}
