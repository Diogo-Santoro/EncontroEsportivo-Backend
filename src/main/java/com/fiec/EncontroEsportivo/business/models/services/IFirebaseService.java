package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.dto.LoginRequest;
import com.fiec.EncontroEsportivo.business.models.dto.RegisterRequest;

public interface IFirebaseService {
    void login(String email, String password) throws Exception;

    void register(String email, String password) throws Exception;
}

