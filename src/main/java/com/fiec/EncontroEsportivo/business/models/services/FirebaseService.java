package com.fiec.EncontroEsportivo.business.models.services;

import com.fiec.EncontroEsportivo.business.models.dto.FirebaseAuthRequest;
import com.fiec.EncontroEsportivo.business.models.dto.FirebaseAuthResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FirebaseService implements IFirebaseService {
    private String WEBKEY = "AIzaSyAaFVOdxOEPMdln0CdThIdL_V7X7W5Q5Ww";
    private String loginUrl = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword" +
            "?key=" +  WEBKEY;
    private String registerUrl = "https://identitytoolkit.googleapis.com/v1/accounts:signUp" +
            "?key=" + WEBKEY ;

    @Override
    public void register(String email, String password) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        FirebaseAuthRequest firebaseAuthRequest = FirebaseAuthRequest.builder()
                .email(email)
                .password(password)
                .returnSecureToken(true)
                .build();
        HttpEntity<FirebaseAuthRequest> httpEntity = new HttpEntity<>(firebaseAuthRequest);
        System.out.println(registerUrl);
        ResponseEntity<FirebaseAuthResponse> response =
                restTemplate.exchange(registerUrl, HttpMethod.POST, httpEntity, FirebaseAuthResponse.class);

        if(response.getStatusCodeValue() != 200 ){
            throw new Exception("Nao pode registrar");
        }
        System.out.println(response.getBody());
    }

    @Override
    public void login(String email, String password) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        FirebaseAuthRequest firebaseAuthRequest = FirebaseAuthRequest.builder()
                .email(email)
                .password(password)
                .returnSecureToken(true)
                .build();
        HttpEntity<FirebaseAuthRequest> httpEntity = new HttpEntity<>(firebaseAuthRequest);
        ResponseEntity<FirebaseAuthResponse> response =
                restTemplate.exchange(loginUrl, HttpMethod.POST, httpEntity, FirebaseAuthResponse.class);
        if(response.getStatusCodeValue() != 200  ){
            throw new Exception("Nao pode logar");
        }
        System.out.println(response.getBody());
        UsernamePasswordAuthenticationToken t = new UsernamePasswordAuthenticationToken(response.getBody().getEmail(), response.getBody().getIdToken());
        SecurityContextHolder.getContext().setAuthentication(t);
    }


}