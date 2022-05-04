package com.fiec.EncontroEsportivo.business.models.controllers;

import com.fiec.EncontroEsportivo.business.models.entities.Lugar;
import com.fiec.EncontroEsportivo.business.models.services.ILugarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lugar")
public class LugarController {

    @Autowired
    ILugarService lugarService;

    @GetMapping
    public List<Lugar> getLugar()  {
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
    public void atualizaLugar(@PathVariable("idLugar") String idLugar, @RequestBody Lugar lugar) {
        lugarService.atualizaLugar(lugar, idLugar);
    }

    @DeleteMapping("/{idLugar}")
    public void deletaLugar(@PathVariable("idLugar") String idLugar) {
        lugarService.deletaLugar(idLugar);
    }

}
