package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.entities.Lugar;

import java.util.List;

public interface ILugarService {
    List<Lugar> getLugar();

    void saveLugar(Lugar lugar);

    Lugar pegaLugar(String id_lugar);

    void atualizaLugar(Lugar lugar, String id_lugar);

    void deletaLugar(String id_lugar);
}
