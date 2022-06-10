package com.fiec.EncontroEsportivo.business.models.controllers;

import com.fiec.EncontroEsportivo.EsporteEnum;
import com.fiec.EncontroEsportivo.business.models.dto.LugarRequestDto;
import com.fiec.EncontroEsportivo.business.models.dto.LugarResponseDto;
import com.fiec.EncontroEsportivo.business.models.entities.Lugar;
import com.fiec.EncontroEsportivo.business.models.entities.Usuario;
import com.fiec.EncontroEsportivo.business.models.services.ILugarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lugar")
public class LugarController {

    @Autowired
    ILugarService lugarService;

    @GetMapping
    public List<Lugar> getLugar(){
        return lugarService.getLugar();

    }

    @PostMapping
    public void saveLugar(@RequestBody Lugar lugar) {
        lugarService.saveLugar(lugar);
    }

    @GetMapping("/{idLugar}")
    public Lugar pegaLugar(@PathVariable("idLugar") String idLugar) {

        return lugarService.pegaLugar(idLugar);
    }

    @PutMapping("/{idLugar}")
    public void atualizaLugar(@PathVariable("idLugar") String idLugar, @RequestBody LugarRequestDto lugarRequestDto) {
        Lugar lugar = Lugar.builder()
                .cep(lugarRequestDto.getCep())
                .descricao(lugarRequestDto.getDescricao())
                .disponibilidade(lugarRequestDto.getDisponibilidade())
                .esporteDisp(lugarRequestDto.getDisponibilidade())

                .build();



        lugarService.atualizaLugar(lugar, idLugar, lugarRequestDto.getIdEvento());
    }

    @DeleteMapping("/{idLugar}")
    public void deletaLugar(@PathVariable("idLugar") String idLugar) {
        lugarService.deletaLugar(idLugar);
    }

}
