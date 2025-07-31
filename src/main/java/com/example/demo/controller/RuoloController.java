package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RuoloCreateDto;
import com.example.demo.dto.RuoloDto;
import com.example.demo.mapper.RuoloMapper;
import com.example.demo.model.Ruolo;
import com.example.demo.model.Utente;
import com.example.demo.service.RuoloService;
import com.example.demo.service.UtenteService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/ruoli")
@RequiredArgsConstructor
public class RuoloController {
    
    private final RuoloMapper ruoloMapper;
    private final RuoloService ruoloService;

    @GetMapping("/{id}")
    public ResponseEntity<RuoloCreateDto> getRuolo(@PathVariable Long id) {

        Ruolo ruolo = ruoloService.getRuolo(id);

        if (ruolo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ruoloMapper.ruoloToRuoloCreateDto(ruolo));
    }

    @GetMapping
    public ResponseEntity<List<RuoloDto>> getAllRuoli() {

        List<Ruolo> ruoli = ruoloService.getAll();
        
        if (ruoli.isEmpty()) {

            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(
            ruoli.stream()
                .map(ruoloMapper::ruoloToRuoloDto)
                .collect(Collectors.toList())
        );
    }

    @PostMapping
    public RuoloCreateDto creaRuolo(@RequestBody RuoloCreateDto ruoloCreateDto) {

        Ruolo ruolo = ruoloMapper.ruoloCreateDtoToRuolo(ruoloCreateDto);
        Ruolo savedRuolo = ruoloService.creaRuolo(ruolo);

        return ruoloMapper.ruoloToRuoloCreateDto(savedRuolo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RuoloDto> putRuolo(@PathVariable Long id, @RequestBody String entity) {
        
        Ruolo ruolo = ruoloMapper.ruoloDtoToRuolo(entity);
        Ruolo aggiornaRuolo = ruoloService.putRuolo(id, ruolo);

        if(aggiornaRuolo == null){

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ruoloMapper.ruoloToRuoloDto(aggiornaRuolo));
    }


}
    


