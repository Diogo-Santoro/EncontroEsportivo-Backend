package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.dto.ProprietarioRequestDto;
import com.fiec.EncontroEsportivo.business.models.entities.User;
import com.fiec.EncontroEsportivo.business.models.repositories.IProprietarioRepositorio;
import com.fiec.EncontroEsportivo.business.models.entities.Proprietario;
import com.fiec.EncontroEsportivo.business.models.repositories.IUserRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class ProprietarioService implements IProprietarioService {

        @Autowired
        IProprietarioRepositorio proprietarioRepositorio;
        @Autowired
        IUserRepositorio userRepositorio;

        @Override
        public List<Proprietario> getProprietario() {

            return proprietarioRepositorio.findAll();

        }


        @Override
        public void saveProprietario(ProprietarioRequestDto proprietario) {
            User user = userRepositorio.save(User.builder()
                            .email(proprietario.getEmail())
                            .role("PROPRIETARIO")

                    .build());
            proprietarioRepositorio.save(Proprietario.builder()
                            .cnpj(proprietario.getCnpj())
                            .nome(proprietario.getNome())
                            .telefone(proprietario.getTelefone())
                            .user(user)
                    .build());

        }

        @Override
        public void atualizaProprietario(Proprietario proprietario, String idProprietario) {


            Proprietario proprietarioAnterior = proprietarioRepositorio.findById(idProprietario).orElseThrow();
            proprietarioAnterior.setNome(proprietario.getNome());
            proprietarioAnterior.setTelefone(proprietario.getTelefone());
            proprietarioAnterior.setCnpj(proprietario.getCnpj());


            proprietarioRepositorio.save(proprietarioAnterior);

        }

        @Override
        public Proprietario pegaProprietario(String idProprietario) {
            return proprietarioRepositorio.findById(idProprietario).orElse(null);

        }

        @Override
        public void deletaProprietario(String idProprietario) {
            proprietarioRepositorio.deleteById(idProprietario);
        }


    }










