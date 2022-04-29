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

    @GetMapping("/{id_lugar}")
    public Lugar pegaLugar(@PathVariable("id_lugar") String id_lugar) {

        return lugarService.pegaLugar(id_lugar);
    }

    @PutMapping("/{id_lugar}")
    public void atualizaLugar(@PathVariable("id_lugar") String id_lugar, @RequestBody Lugar lugar) {
        lugarService.atualizaLugar(lugar, id_lugar);
    }

    @DeleteMapping("/{id_lugar}")
    public void deletaLugar(@PathVariable("id_lugar") String id_lugar) {
        lugarService.deletaLugar(id_lugar);
    }

}
