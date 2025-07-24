package com.example.demo.mapper;

import com.example.demo.dto.UtenteCreateDto;
import com.example.demo.dto.UtenteDto;
import com.example.demo.model.Utente;

public class UtenteMapper {
    
    public static UtenteDto utenteDto(Utente utente){

        if(utente != null){

            return new UtenteDto(
                utente.getId()

            );
        }

        return null;
    }

    public static UtenteCreateDto creaUtenteDto(Utente utente){
        
        if(utente == null) return null;
        
        return new UtenteCreateDto(
            utente.getNome(),
            utente.getCognome()

        );
    }

    public static Utente utenteDtoToUtente(UtenteDto utenteDto){

        if(utenteDto != null){

            Utente utente = new Utente();
            utente.setId(utenteDto.getId());

            return utente;
        }

        return null;
    }
    // from utenteCreateDto to Utente model
    public static Utente utenteCreateDtoToUtente(Utente entitaSave){

        if(entitaSave != null){

            Utente utente = new Utente();
            utente.setNome(entitaSave.getNome());
            utente.setCognome(entitaSave.getCognome());

            return utente;
        }

        return null;
    }
}
