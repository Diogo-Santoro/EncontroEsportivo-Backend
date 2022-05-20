package com.fiec.EncontroEsportivo.business.models.repositories;

import com.fiec.EncontroEsportivo.business.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository



public interface IUsuarioRepositorio extends JpaRepository<Usuario, String> {


}
