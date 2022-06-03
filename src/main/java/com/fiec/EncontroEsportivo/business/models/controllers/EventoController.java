package com.fiec.EncontroEsportivo.business.models.controllers;

import com.fiec.EncontroEsportivo.business.models.dto.EventoListedResponse;
import com.fiec.EncontroEsportivo.business.models.entities.Evento;
import com.fiec.EncontroEsportivo.business.models.entities.Usuario;
import com.fiec.EncontroEsportivo.business.models.services.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    IEventoService eventoService;

    @GetMapping
    public EventoListedResponse getListedEventos(@RequestBody Evento evento){

        List<EventoListedResponse> usuarioResponseList = evento.get().stream()
                .map(evento -> EventoListedResponse.builder()
                        .idUsuario(evento.get().getidUsuario())
                        .nomeUsuario(evento.get().getnomeUsuario())
                        .build()
                ).collect(Collectors.toList());
        return EventoListedResponse.builder()
                .evento(usuarioResponseList)
                .total(evento.get()).build();

    }

    @PostMapping
    public void saveEvento(@RequestBody Evento evento) {
        eventoService.saveEvento(evento);
    }

    @GetMapping("/{idEvento}")
    public Evento pegaEvento(@PathVariable("idEvento") String idEvento) {

        return eventoService.pegaEvento(idEvento);
    }

    @DeleteMapping("/{idEvento}")
    public void deletaEvento(@PathVariable("idEvento") String idEvento) {
        eventoService.deletaEvento(idEvento);
    }

}
