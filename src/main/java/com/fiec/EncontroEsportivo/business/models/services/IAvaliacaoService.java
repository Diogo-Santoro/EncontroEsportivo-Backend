package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.entities.Avaliacao;
import com.fiec.EncontroEsportivo.business.models.entities.Lugar;

import java.util.List;

public interface IAvaliacaoService {
    List<Lugar> getAvaliacao();

    void saveAvaliacao(Avaliacao avaliacao);

    Avaliacao pegaAvaliacao(String id_avaliacao);

    void atualizaAvaliacao(Avaliacao avaliacao, String id_avaliacao);

    void deletaAvaliacao(String id_avaliacao);

}
