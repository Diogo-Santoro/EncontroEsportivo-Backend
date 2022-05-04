package com.fiec.EncontroEsportivo.business.models.repositories;

import com.fiec.EncontroEsportivo.business.models.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEventoRepositorio extends JpaRepository<Evento, String> {
    List<Evento> findByidEvento(String idEvento);

}
