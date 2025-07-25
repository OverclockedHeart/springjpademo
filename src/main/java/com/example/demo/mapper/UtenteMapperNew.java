package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.dto.UtenteCreateDto;
import com.example.demo.dto.UtenteDto;
import com.example.demo.dto.UtenteModDto;
import com.example.demo.model.Utente;

@Mapper(componentModel = "spring")
public interface UtenteMapperNew {

    //Dto -> Entity
    Utente utenteDtoUtente(UtenteDto utenteDto);
    Utente utenteCreateDtoToUtente(UtenteCreateDto utenteDto);
    
    @Mapping(target = "id", source = "identificativo")
    @Mapping(target = "nome", source = "nominativo")
    Utente utenteModDtoToUtente(UtenteModDto utenteModDto);

    //Entity -> Dto
    UtenteDto utenteDto(Utente utente);
    UtenteCreateDto creaUtenteDto(Utente utente);

    @Mapping(target = "identificativo", source = "id")
    @Mapping(target = "nominativo", source = "nome")
    UtenteModDto utenteModUtenteToDto(Utente utente);
}
