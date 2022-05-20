package com.fiec.EncontroEsportivo.business.models.controllers;

import com.fiec.EncontroEsportivo.business.models.entities.Evento;
import com.fiec.EncontroEsportivo.business.models.services.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    IEventoService eventoService;

    @GetMapping
    public List<Evento> getEvento()  {
        return eventoService.getEvento();
    }

    @PostMapping
    public void saveEvento(@RequestBody Evento evento) {
        eventoService.saveEvento(evento);
    }

    @GetMapping("/{idEvento}")
    public Evento pegaEvento(@PathVariable("idEvento") String idEvento) {

        return eventoService.pegaEvento(idEvento);
    }

    @PutMapping("/{idEvento}")
    public void atualizaEvento(@PathVariable("idEvento") String idEvento, @RequestBody Evento evento) {
        eventoService.atualizaEvento(evento, idEvento);
    }
    @DeleteMapping("/{idEvento}")
    public void deletaEvento(@PathVariable("idEvento") String idEvento) {
        eventoService.deletaEvento(idEvento);
    }

}
