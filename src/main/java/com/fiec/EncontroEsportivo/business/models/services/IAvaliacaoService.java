package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.entities.Avaliacao;

import java.util.List;

public interface IAvaliacaoService {

    List<Avaliacao> getAvaliacao();

    void saveAvaliacao(Avaliacao avaliacao);

    void atualizaAvaliacao(Avaliacao avaliacao, String idAvaliacao);

    Avaliacao pegaAvaliacao(String idAvaliacao);

    void deletaAvaliacao(String idAvaliacao);
}
