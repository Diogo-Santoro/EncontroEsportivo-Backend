package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.entities.Lugar;

import java.util.List;

public interface ILugarService {

    void saveLugar(Lugar lugar);

    Lugar pegaLugar(String id_lugar);

    void atualizaLugar(Lugar lugar, String id_lugar, String idEvento);

    void deletaLugar(String id_lugar);

    List<Lugar> getLugar();
}
