package com.fiec.EncontroEsportivo.business.models.repositories;

import com.fiec.EncontroEsportivo.business.models.entities.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProprietarioRepositorio extends JpaRepository<Proprietario, String> {

}
