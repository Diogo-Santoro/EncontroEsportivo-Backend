package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.entities.Evento;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IEventoService {
    Evento pegaEvento(String idEvento);

    void saveEvento(Evento evento);

    void atualizaEvento(Evento evento, String idEvento);

    void deletaEvento(String idEvento);

    List<Evento> getEvento();
}
