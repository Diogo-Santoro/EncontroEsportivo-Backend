package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.entities.Evento;
import com.fiec.EncontroEsportivo.business.models.entities.Lugar;
import com.fiec.EncontroEsportivo.business.models.repositories.IEventoRepositorio;
import com.fiec.EncontroEsportivo.business.models.repositories.ILugarRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LugarService implements ILugarService{

    @Autowired
    ILugarRepositorio lugarRepositorio;

    @Autowired
    IEventoRepositorio eventoRepositorio;



    @Override
    public void saveLugar(Lugar lugar) {
        lugarRepositorio.save(lugar);
    }

    @Override
    public void atualizaLugar(Lugar lugar, String idLugar, String idEvento) {

        Evento evento = eventoRepositorio.findById(idEvento).orElse(null);
        Lugar lugarAnterior = lugarRepositorio.findById(idLugar).orElseThrow();
        lugarAnterior.setNomeLugar(lugar.getNomeLugar());
        lugarAnterior.setDescricao(lugar.getDescricao());
        lugarAnterior.setCep(lugar.getCep());
        lugarAnterior.setNumero(lugar.getNumero());
        lugarAnterior.setDisponibilidade(lugar.getDisponibilidade());
        if (evento != null){
            lugarAnterior.getEventos().add(evento);
        }
        lugarRepositorio.save(lugarAnterior);

    }

    @Override
    public Lugar pegaLugar(String idLugar) {
        return lugarRepositorio.findById(idLugar).orElse(null);

    }

    @Override
    public void deletaLugar(String idLugar) {
        lugarRepositorio.deleteById(idLugar);
    }

    @Override
    public List<Lugar> getLugar() {

        return lugarRepositorio.findAll();

    }


}


