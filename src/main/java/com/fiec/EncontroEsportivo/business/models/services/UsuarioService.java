package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.entities.User;
import com.fiec.EncontroEsportivo.business.models.entities.Usuario;
import com.fiec.EncontroEsportivo.business.models.repositories.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    IUsuarioRepositorio usuarioRepositorio;

    @Override
    public List<Usuario> getUsuario() {

        return usuarioRepositorio.findAll();

    }


    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    @Override
    public void atualizaUsuario(User user, Usuario usuario, String idUsuario) {


        Usuario usuarioAnterior = usuarioRepositorio.findById(idUsuario).orElse(null);

        usuarioAnterior.getUser().setNome(user.getNome());
        usuarioAnterior.getUser().setPassword(user.getPassword());

        usuarioRepositorio.save(usuarioAnterior);

    }

    @Override
    public Usuario pegaUsuario(String idUsuario) {
        return usuarioRepositorio.findById(idUsuario).orElse(null);

    }

    @Override
    public void deletaUsuario(String idUsuario) {
        usuarioRepositorio.deleteById(idUsuario);
    }



}
