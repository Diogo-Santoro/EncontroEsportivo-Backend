package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.entities.Avaliacao;
import com.fiec.EncontroEsportivo.business.models.repositories.IAvaliacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AvaliacaoService implements IAvaliacaoService {
    @Autowired
    IAvaliacaoRepositorio avaliacaoRepositorio;

    @Override
    public List<Avaliacao> getAvaliacao() {

        return avaliacaoRepositorio.findAll();

    }


    @Override
    public void saveAvaliacao(Avaliacao avaliacao) {
        avaliacaoRepositorio.save(avaliacao);
    }

    @Override
    public void atualizaAvaliacao(Avaliacao avaliacao, String idAvaliacao) {


        Avaliacao avaliacaoAnterior = avaliacaoRepositorio.findById(idAvaliacao).orElseThrow();
        avaliacaoAnterior.setAvaliacao(avaliacao.getAvaliacao());
        avaliacaoRepositorio.save(avaliacaoAnterior);

    }

    @Override
    public Avaliacao pegaAvaliacao(String idAvaliacao) {
        return avaliacaoRepositorio.findById(idAvaliacao).orElse(null);

    }

    @Override
    public void deletaAvaliacao(String idAvaliacao) {
        avaliacaoRepositorio.deleteById(idAvaliacao);
    }


}







