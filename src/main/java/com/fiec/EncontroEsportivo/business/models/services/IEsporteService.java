package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.entities.Esporte;

import java.util.List;

public interface IEsporteService {
    void atualizaEsporte(Esporte esporte, String id_esporte);

    Esporte pegaEsporte(String id_esporte);

    void saveEsporte(Esporte esporte);

    List<Esporte> getEsporte();

    void deletaEsporte(String id_esporte);
}
