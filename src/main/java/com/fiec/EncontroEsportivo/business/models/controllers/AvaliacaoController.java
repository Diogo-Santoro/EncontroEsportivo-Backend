package com.fiec.EncontroEsportivo.business.models.controllers;

import com.fiec.EncontroEsportivo.business.models.entities.Avaliacao;
import com.fiec.EncontroEsportivo.business.models.services.IAvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    IAvaliacaoService avaliacaoService;

    @GetMapping
    public List<Avaliacao> getAvaliacao() {
        return avaliacaoService.getAvaliacao();
    }

    @PostMapping
    public void saveAvaliacao(@RequestBody Avaliacao avaliacao) {
        avaliacaoService.saveAvaliacao(avaliacao);
    }

    @GetMapping("/{idAvaliacao}")
    public Avaliacao pegaAvaliacao(@PathVariable("idAvaliacao") String idAvaliacao) {

        return avaliacaoService.pegaAvaliacao(idAvaliacao);
    }

    @PutMapping("/{idAvaliacao}")
    public void atualizaAvaliacao(@PathVariable("idAvaliacao") String idAvaliacao, @RequestBody Avaliacao avaliacao) {
        avaliacaoService.atualizaAvaliacao(avaliacao, idAvaliacao);
    }

    @DeleteMapping("/{idAvaliacao}")
    public void deletaAvaliacao(@PathVariable("idAvaliacao") String idAvaliacao) {
        avaliacaoService.deletaAvaliacao(idAvaliacao);


    }


}
