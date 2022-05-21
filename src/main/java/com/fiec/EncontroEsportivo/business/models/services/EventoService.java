package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.entities.Evento;

import com.fiec.EncontroEsportivo.business.models.repositories.IEventoRepositorio;
import org.apache.naming.EjbRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventoService implements IEventoService{
    @Autowired
    IEventoRepositorio eventoRepositorio;

    @Override
    public List<Evento> getEvento() {

        return eventoRepositorio.findAll();

    }


    @Override
    public void saveEvento(Evento evento) {
        eventoRepositorio.save(evento);
    }

    @Override
    public void atualizaEvento(Evento evento, String idEvento) {


        Evento eventoAnterior = eventoRepositorio.findById(idEvento).orElseThrow();
        eventoAnterior.setNomeEvento(evento.getNomeEvento());
        eventoAnterior.setDataHoraInicio(evento.getDataHoraInicio());
        eventoAnterior.setDataHoraFim(evento.getDataHoraFim());
        eventoAnterior.setParticipantes(evento.getParticipantes());
        eventoRepositorio.save(eventoAnterior);

    }

    @Override
    public Evento pegaEvento(String idEvento) {
        return eventoRepositorio.findById(idEvento).orElse(null);

    }

    @Override
    public void deletaEvento(String idEvento) {
        eventoRepositorio.deleteById(idEvento);
    }


}



