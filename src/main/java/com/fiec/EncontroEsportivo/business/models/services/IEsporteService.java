package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.entities.Esporte;

import java.util.List;

public interface IEsporteService {

    Esporte pegaEsporte(String idEsporte);

    void saveEsporte(Esporte esporte);

    List<Esporte> getEsporte();

    void deletaEsporte(String idEsporte);
}
