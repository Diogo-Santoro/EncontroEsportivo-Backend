package com.fiec.EncontroEsportivo.business.models.repositories;

import com.fiec.EncontroEsportivo.business.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface IUserRepositorio extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);



}
