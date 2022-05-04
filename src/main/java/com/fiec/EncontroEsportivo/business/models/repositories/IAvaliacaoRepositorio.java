package com.fiec.EncontroEsportivo.business.models.repositories;

import com.fiec.EncontroEsportivo.business.models.entities.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAvaliacaoRepositorio extends JpaRepository<Avaliacao, String> {
    List<Avaliacao> findByIdAvaliacao(String idAvaliacao);
}
