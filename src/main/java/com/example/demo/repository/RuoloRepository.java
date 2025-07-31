package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Ruolo;

public interface RuoloRepository extends JpaRepository<Ruolo, Long> {
}