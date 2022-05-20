package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.entities.User;
import com.fiec.EncontroEsportivo.business.models.entities.Usuario;
import com.fiec.EncontroEsportivo.business.models.repositories.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    IUsuarioRepositorio usuarioRepositorio;

    public void atualizaUsuariocomFoto(User user, Usuario usuario, String idUsuario) {


        Usuario usuarioAnterior = usuarioRepositorio.findById(idUsuario).orElse(null);

        usuarioAnterior.setProfileImage(usuario.getProfileImage());


        usuarioRepositorio.save(usuarioAnterior);

    }}