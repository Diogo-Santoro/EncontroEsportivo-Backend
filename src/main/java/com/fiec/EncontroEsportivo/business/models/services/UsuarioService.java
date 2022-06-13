package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.entities.User;
import com.fiec.EncontroEsportivo.business.models.entities.Usuario;
import com.fiec.EncontroEsportivo.business.models.repositories.IUsuarioRepositorio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
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
    public Usuario pegaUsuario(String idUsuario) {
        return usuarioRepositorio.findById(idUsuario).orElse(null);

    }

    @Override
    public void deletaUsuario(String idUsuario) {
        usuarioRepositorio.deleteById(idUsuario);
    }



    @Override
    public void atualizaUsuario(Usuario usuario, String idUsuario) {
        Usuario usuarioAnterior = usuarioRepositorio.findById(idUsuario).orElse(null);
        usuarioAnterior.setNomeUsuario(usuario.getNomeUsuario());
        usuarioAnterior.setBairro(usuario.getBairro());
        usuarioAnterior.setEsporteFav(usuario.getEsporteFav());
        usuarioAnterior.setProfileImage(usuario.getProfileImage());
        usuarioAnterior.setCep(usuario.getCep());


        usuarioRepositorio.save(usuarioAnterior);
        log.info("Usuário Atualizado");

    }

}
