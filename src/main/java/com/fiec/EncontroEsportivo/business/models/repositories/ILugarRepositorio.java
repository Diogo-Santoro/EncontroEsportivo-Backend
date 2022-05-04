package com.fiec.EncontroEsportivo.business.models.repositories;

import com.fiec.EncontroEsportivo.business.models.entities.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILugarRepositorio extends JpaRepository<Lugar, String> {
    List<Lugar> findByidLugar( String idLugar);
}
