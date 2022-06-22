package com.fiec.EncontroEsportivo.business.models.controllers;

import com.fiec.EncontroEsportivo.EsporteEnum;
import com.fiec.EncontroEsportivo.business.models.dto.EventoListedResponse;
import com.fiec.EncontroEsportivo.business.models.entities.Evento;
import com.fiec.EncontroEsportivo.business.models.entities.Lugar;
import com.fiec.EncontroEsportivo.business.models.services.IEventoService;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    IEventoService eventoService;


    @GetMapping
    public List<Evento> getEvento(){
        return eventoService.getEvento();

    }

    @GetMapping("/{idEvento}/participantes")
    public List <EventoListedResponse> getListedEventos(@PathParam("idEvento") String idEvento){
        Evento evento = eventoService.pegaEvento(idEvento);

        return evento.getParticipantes().stream().map(p -> EventoListedResponse.builder()
                .nomeUsuario(p.getNomeUsuario())
                .idUsuario(p.getIdUsuario())
                .build()
        ).collect(Collectors.toList());
    }

    @PostMapping
    public void saveEvento(@RequestBody Evento evento) {
        eventoService.saveEvento(evento);
        log.info("Evento criado!");
    }

    @GetMapping("/{idEvento}")
    public EventoDto pegaEvento(@PathVariable("idEvento") String idEvento) {

        return EventoDto.createDto(eventoService.pegaEvento(idEvento));
    }

    @DeleteMapping("/{idEvento}")
    public void deletaEvento(@PathVariable("idEvento") String idEvento) {
        eventoService.deletaEvento(idEvento);
    }

    @Data
    @Builder
    static class EventoDto{
        private String idEvento;
        private Lugar lugar;

        private String nomeEvento;

        private String dataHoraInicio;

        private String dataHoraFim;

        private String nomeLugar;

        private List<EsporteEnum> esportes;

        public static EventoDto createDto(Evento evento){
            return EventoDto.builder()
                    .idEvento(evento.getIdEvento())
                    .dataHoraInicio(evento.getDataHoraInicio())
                    .dataHoraFim(evento.getDataHoraFim())
                    .nomeEvento(evento.getNomeEvento())
                    .lugar(evento.getLugar())
                    .nomeLugar(evento.getNomeLugar())

                    .esportes(Arrays.stream(evento.getEsportes().split(",")).map(EsporteEnum::valueOf).collect(Collectors.toList()))
                    .build();
        }

    }
}
