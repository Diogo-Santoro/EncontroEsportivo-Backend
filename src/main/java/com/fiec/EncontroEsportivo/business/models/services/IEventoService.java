package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.entities.Evento;

import java.util.List;

public interface IEventoService {
    Evento pegaEvento(String idEvento);

    void saveEvento(Evento evento);

    List<Evento> getEvento();

    void atualizaEvento(Evento evento, String idEvento);

    void deletaEvento(String idEvento);
}
