package com.fiec.EncontroEsportivo.business.models.controllers;
import com.fiec.EncontroEsportivo.business.models.entities.Esporte;
import com.fiec.EncontroEsportivo.business.models.services.IEsporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/esporte")
public class EsporteController {

    @Autowired
    IEsporteService esporteService;

    @GetMapping
    public List<Esporte> getEsporte()  {
        return esporteService.getEsporte();
    }

    @PostMapping
    public void saveEsporte(@RequestBody Esporte esporte) {
        esporteService.saveEsporte(esporte);
    }

    @GetMapping("/{id_esporte}")
    public Esporte pegaEsporte(@PathVariable("id_esporte") String id_esporte) {

        return esporteService.pegaEsporte(id_esporte);
    }


    @DeleteMapping("/{id_lugar}")
    public void deletaEsporte(@PathVariable("id_esporte") String id_esporte) {
        esporteService.deletaEsporte(id_esporte);
    }

}
