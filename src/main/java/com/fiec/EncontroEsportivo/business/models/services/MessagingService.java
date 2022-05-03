package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.entities.User;
import com.fiec.EncontroEsportivo.business.models.repositories.IUserRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagingService implements IMessagingService{
    @Autowired
    IUserRepositorio userRepositorio;
    @Override
    public void registraFcmToken(User user, String fcmToken) {
        user.setFcmToken(fcmToken);
        userRepositorio.save(user);
    }
}
