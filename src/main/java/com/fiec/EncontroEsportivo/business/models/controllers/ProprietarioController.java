package com.fiec.EncontroEsportivo.business.models.controllers;

import com.fiec.EncontroEsportivo.business.models.dto.ProprietarioRequestDto;
import com.fiec.EncontroEsportivo.business.models.entities.Proprietario;
import com.fiec.EncontroEsportivo.business.models.services.IProprietarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/proprietario")
public class ProprietarioController {

    @Autowired
    IProprietarioService proprietarioService;

    @GetMapping
    public List<Proprietario> getProprietario()  {
        return proprietarioService.getProprietario();
    }

    @PostMapping
    public void savePropritario(@RequestBody ProprietarioRequestDto proprietario) {
        proprietarioService.saveProprietario(proprietario);
        log.info("Proprietário Cadastrado");
    }

    @GetMapping("/{idProprietario}")
    public Proprietario pegaProprietario(@PathVariable("idProprietario") String idProprietario) {

        return proprietarioService.pegaProprietario(idProprietario);
    }

    @PutMapping("/{idProprietario}")
    public void atualizaProprietario(@PathVariable("idProprietario") String idProprietario, @RequestBody Proprietario proprietario) {
        proprietarioService.atualizaProprietario(proprietario, idProprietario);
        log.info("Proprietário com Cadastro Terminado");
    }

    @DeleteMapping("/{idProprietario}")
    public void deletaProprietario(@PathVariable("idProprietario") String idProprietario) {
        proprietarioService.deletaProprietario(idProprietario);
    }

}
