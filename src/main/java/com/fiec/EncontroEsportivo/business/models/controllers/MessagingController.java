package com.fiec.EncontroEsportivo.business.models.controllers;


import com.fiec.EncontroEsportivo.business.models.dto.FcmRequest;
import com.fiec.EncontroEsportivo.business.models.entities.User;
import com.fiec.EncontroEsportivo.business.models.services.IMessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messaging")
public class MessagingController {

    @Autowired
    IMessagingService messagingService;
    @PostMapping("/register")
    public void registraFcmToken(@RequestBody FcmRequest fcmRequest, Authentication authentication){
        User user = (User) authentication.getPrincipal();
        String fcmToken = fcmRequest.getToken();
        messagingService.registraFcmToken(user, fcmToken);


    }
}
