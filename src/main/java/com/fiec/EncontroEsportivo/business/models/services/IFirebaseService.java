package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.dto.FirebaseAuthRequest;

public interface IFirebaseService {
    void register(FirebaseAuthRequest firebaseAuthRequest) throws Exception;

    void login(FirebaseAuthRequest firebaseAuthRequest) throws Exception;
}

