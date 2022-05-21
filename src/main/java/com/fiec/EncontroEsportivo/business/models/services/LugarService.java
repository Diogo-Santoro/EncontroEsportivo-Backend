package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.entities.Lugar;
import com.fiec.EncontroEsportivo.business.models.entities.Usuario;
import com.fiec.EncontroEsportivo.business.models.repositories.ILugarRepositorio;
import com.fiec.EncontroEsportivo.business.models.repositories.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LugarService implements ILugarService{

    @Autowired
    ILugarRepositorio lugarRepositorio;

    @Override
    public List<Lugar> getLugar() {

        return lugarRepositorio.findAll();

    }


    @Override
    public void saveLugar(Lugar lugar) {
        lugarRepositorio.save(lugar);
    }

    @Override
    public void atualizaLugar(Lugar lugar, String idLugar) {


        Lugar lugarAnterior = lugarRepositorio.findById(idLugar).orElseThrow();
        lugarAnterior.setNomeLugar(lugar.getNomeLugar());
        lugarAnterior.setDescricao(lugar.getDescricao());
        lugarAnterior.setValor(lugar.getValor());
        lugarAnterior.setRua(lugar.getRua());
        lugarAnterior.setCep(lugar.getCep());
        lugarAnterior.setBairro(lugar.getBairro());
        lugarAnterior.setNumero(lugar.getNumero());
        lugarAnterior.setDisponibilidade(lugar.getDisponibilidade());
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


}


