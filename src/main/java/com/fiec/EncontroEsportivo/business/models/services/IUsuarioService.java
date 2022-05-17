package com.fiec.EncontroEsportivo.business.models.services;


import com.fiec.EncontroEsportivo.business.models.entities.User;
import com.fiec.EncontroEsportivo.business.models.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> getUsuario();

    void saveUsuario(Usuario usuario);

    void atualizaUsuario(User user, Usuario usuario, String idUsuario);

    Usuario pegaUsuario(String idUsuario);

    void deletaUsuario(String idUsuario);

}

