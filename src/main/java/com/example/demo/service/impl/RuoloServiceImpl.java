package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.RuoloNonTrovatoEx;
import com.example.demo.model.Ruolo;
import com.example.demo.repository.RuoloRepository;
import com.example.demo.service.RuoloService;

@Service
public class RuoloServiceImpl implements RuoloService {

    @Autowired
    RuoloRepository ruoloRepository;

    @Override
    public Ruolo creaRuolo(Ruolo ruolo) {
     
        return ruoloRepository.save(ruolo);
    }

    @Override
    public Ruolo getRuolo(Long id) {
        
        return ruoloRepository.findById(id).orElseThrow(() -> new RuoloNonTrovatoEx(id));
    }

    @Override
    public List<Ruolo> getAll() {

        return ruoloRepository.findAll();
    }

    @Override
    public Ruolo putRuolo(Long id, Ruolo ruolo) {

        if (ruoloRepository.existsById(id)) {
            ruolo.setId(id);
            
            return ruoloRepository.save(ruolo);
        }

        return null;
    }
}
