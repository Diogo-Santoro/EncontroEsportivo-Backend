package com.fiec.EncontroEsportivo.business.models.controllers;

import com.fiec.EncontroEsportivo.business.models.entities.Avaliacao;
import com.fiec.EncontroEsportivo.business.models.services.IAvaliacaoService;
import com.fiec.EncontroEsportivo.business.models.entities.Lugar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    IAvaliacaoService avaliacaoService;

    @GetMapping
    public List<Lugar> getAvaliacao()  {
        return avaliacaoService.getAvaliacao();
    }

    @PostMapping
    public void saveAvaliacao(@RequestBody Avaliacao avaliacao) {
        avaliacaoService.saveAvaliacao(avaliacao);
    }

    @GetMapping("/{id_avaliacao}")
    public Avaliacao pegaAvaliacao(@PathVariable("id_avaliacao") String id_avaliacao) {

        return avaliacaoService.pegaAvaliacao(id_avaliacao);
    }

    @PutMapping("/{id_avaliacao}")
    public void atualizaAvaliacao(@PathVariable("id_lugar") String id_avaliacao, @RequestBody Avaliacao avaliacao) {
        avaliacaoService.atualizaAvaliacao(avaliacao, id_avaliacao);
    }

    @DeleteMapping("/{id_avaliacao}")
    public void deletaAvaliacao(@PathVariable("id_avaliacao") String id_avaliacao) {
        avaliacaoService.deletaAvaliacao(id_avaliacao);
    }

}
