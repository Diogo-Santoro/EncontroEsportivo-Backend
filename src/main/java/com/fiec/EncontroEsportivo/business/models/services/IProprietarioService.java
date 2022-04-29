package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.entities.Proprietario;

import java.util.List;

public interface IProprietarioService {
    List<Proprietario> getProprietario();

    void saveProprietario(Proprietario proprietario);

    Proprietario pegaProprietario(String idProprietario);

    void atualizaProprietario(Proprietario proprietario, String idProprietario);

    void deletaProprietario(String idProprietario);
}
