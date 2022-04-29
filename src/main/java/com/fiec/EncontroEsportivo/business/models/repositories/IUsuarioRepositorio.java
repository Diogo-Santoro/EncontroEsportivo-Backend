package com.fiec.EncontroEsportivo.business.models.repositories;

import com.fiec.EncontroEsportivo.business.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, String> {

    List<Usuario> findByidUsuario( String idUsuario);
}
