package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.entities.Esporte;
import com.fiec.EncontroEsportivo.business.models.repositories.IEsporteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EsporteService implements IEsporteService {


    @Autowired
    IEsporteRepositorio esporteRepositorio;

    @Override
    public List<Esporte> getEsporte() {

        return esporteRepositorio.findAll();

    }


    @Override
    public void saveEsporte(Esporte esporte) {
        esporteRepositorio.save(esporte);
    }

    @Override
    public Esporte pegaEsporte(String idEsporte) {
        return esporteRepositorio.findById(idEsporte).orElse(null);

    }

    @Override
    public void deletaEsporte(String idEsporte) {
        esporteRepositorio.deleteById(idEsporte);
    }


}


