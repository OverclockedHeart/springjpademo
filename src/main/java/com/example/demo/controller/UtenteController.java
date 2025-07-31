package com.example.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UtenteCreateDto;
import com.example.demo.dto.UtenteDto;
import com.example.demo.dto.UtenteModDto;
import com.example.demo.mapper.UtenteMapperNew;
import com.example.demo.model.Utente;
import com.example.demo.service.UtenteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UtenteController {

   // @Autowired
    private final UtenteMapperNew utenteMapper;

    //@Autowired
    private final UtenteService utenteService;

    // public UtenteController(UtenteMapperNew utenteMapper, UtenteService utenteService) {
    //     this.utenteMapper = utenteMapper;
    //     this.utenteService = utenteService;
    // }

    @GetMapping("/utente/{id}")
    public ResponseEntity<UtenteModDto> getUtente(@PathVariable Long id) {

        Utente utente = utenteService.getUtente(id);

        if(utente == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(utenteMapper.utenteModUtenteToDto(utente));
    }

    @PostMapping("/utente")
    public UtenteDto creaUtente(@Valid @RequestBody UtenteCreateDto utente) {

        Utente entita = utenteMapper.utenteCreateDtoToUtente(utente);
        Utente entitaSave = utenteService.creaUtente(entita);

        return utenteMapper.utenteDto(entitaSave);
    }

    @PutMapping("utente/{id}")
    public ResponseEntity<UtenteDto> putUtente(@PathVariable Long id, @Valid @RequestBody UtenteDto utenteDto) {

        Utente entita = utenteMapper.utenteDtoUtente(utenteDto);
        Utente aggiornato = utenteService.putUtente(id, entita);

        if (aggiornato == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(utenteMapper.utenteDto(aggiornato));
    }

    @DeleteMapping("utente/{id}")
    public void deleteUtente(@PathVariable Long id) {
        utenteService.cancellaUtente(id);

    }
}
