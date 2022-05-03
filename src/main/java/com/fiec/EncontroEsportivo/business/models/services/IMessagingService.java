package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.entities.User;

public interface IMessagingService {
    void registraFcmToken (User user, String fcmToken);

}
