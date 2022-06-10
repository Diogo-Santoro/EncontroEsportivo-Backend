package com.fiec.EncontroEsportivo.business.models.controllers;

import com.fiec.EncontroEsportivo.EsporteEnum;
import com.fiec.EncontroEsportivo.business.models.dto.EventoListedResponse;
import com.fiec.EncontroEsportivo.business.models.entities.Evento;
import com.fiec.EncontroEsportivo.business.models.entities.Lugar;
import com.fiec.EncontroEsportivo.business.models.entities.Usuario;
import com.fiec.EncontroEsportivo.business.models.services.IEventoService;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    IEventoService eventoService;

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
    }

    @GetMapping
    public AllEventosResponse getAllEventos(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        if (page == null || size == null){
            page = 0;
            size = 10;

        }
        Page<Evento> eventos = eventoService.getAllEventos(page, size);

        return AllEventosResponse.builder()
                .eventoDtos(eventos.stream().map(EventoDto::createDto).collect(Collectors.toList()))
                .totalPages(eventos.getTotalPages())
                .build();
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

        private List<EsporteEnum> esportes;

        public static EventoDto createDto(Evento evento){
            return EventoDto.builder()
                    .idEvento(evento.getIdEvento())
                    .dataHoraInicio(evento.getDataHoraInicio())
                    .dataHoraFim(evento.getDataHoraFim())
                    .nomeEvento(evento.getNomeEvento())
                    .lugar(evento.getLugar())
                    .esportes(Arrays.stream(evento.getEsportes().split(",")).map(EsporteEnum::valueOf).collect(Collectors.toList()))

                    .build();
        }



    }
    @Data
    @Builder
    static class AllEventosResponse{
        int totalPages;
        List<EventoDto> eventoDtos;


    }
}
