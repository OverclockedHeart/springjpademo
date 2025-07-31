package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.dto.RuoloDto;
import com.example.demo.model.Ruolo;
import com.example.demo.dto.RuoloCreateDto;

@Mapper(componentModel = "spring")
public interface RuoloMapper {

    //Dto -> Entity
    Ruolo ruoloDtoToRuolo(String entity);
    Ruolo ruoloCreateDtoToRuolo(RuoloCreateDto ruoloCreateDto);

    //Entity -> Dto
    RuoloDto ruoloToRuoloDto(Ruolo ruolo);
    RuoloCreateDto ruoloToRuoloCreateDto(Ruolo ruolo);

}
