package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Ruolo;

public interface RuoloService {
    Ruolo creaRuolo(Ruolo ruolo);
    Ruolo getRuolo(Long id);
    List<Ruolo> getAll();
    Ruolo putRuolo(Long id, Ruolo ruolo);
    
}
