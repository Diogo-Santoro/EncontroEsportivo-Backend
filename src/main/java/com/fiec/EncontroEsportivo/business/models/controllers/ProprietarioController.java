package com.fiec.EncontroEsportivo.business.models.controllers;
import com.fiec.EncontroEsportivo.business.models.entities.Proprietario;
import com.fiec.EncontroEsportivo.business.models.services.IProprietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proprietario")
public class ProprietarioController {

    @Autowired
    IProprietarioService proprietarioService;

    @GetMapping
    public List<Proprietario> getProprietario()  {
        return proprietarioService.getProprietario();
    }

    @PostMapping
    public void savePropritario(@RequestBody Proprietario proprietario) {
        proprietarioService.saveProprietario(proprietario);
    }

    @GetMapping("/{idProprietario}")
    public Proprietario pegaProprietario(@PathVariable("idProprietario") String idProprietario) {

        return proprietarioService.pegaProprietario(idProprietario);
    }

    @PutMapping("/{idProprietario}")
    public void atualizaProprietario(@PathVariable("idProprietario") String idProprietario, @RequestBody Proprietario proprietario) {
        proprietarioService.atualizaProprietario(proprietario, idProprietario);
    }

    @DeleteMapping("/{idProprietario}")
    public void deletaProprietario(@PathVariable("idProprietario") String idProprietario) {
        proprietarioService.deletaProprietario(idProprietario);
    }

}
