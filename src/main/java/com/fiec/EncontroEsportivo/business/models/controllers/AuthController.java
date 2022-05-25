package com.fiec.EncontroEsportivo.business.models.controllers;

import com.fiec.EncontroEsportivo.business.models.Utils.JwtTokenUtil;
import com.fiec.EncontroEsportivo.business.models.dto.LoginRequest;
import com.fiec.EncontroEsportivo.business.models.dto.RegisterRequest;
import com.fiec.EncontroEsportivo.business.models.dto.TokenResponse;
import com.fiec.EncontroEsportivo.business.models.entities.User;
import com.fiec.EncontroEsportivo.business.models.repositories.IUserRepositorio;
import com.fiec.EncontroEsportivo.business.models.services.IFirebaseService;
import com.fiec.EncontroEsportivo.business.models.services.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    IFirebaseService firebaseService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    IUserRepositorio userRepositorio;

    @PostMapping("/register")

    public void registraUsuarioFirebase(@RequestBody  RegisterRequest firebaseAuthRequest) throws Exception {
        firebaseService.register(firebaseAuthRequest.getEmail(), firebaseAuthRequest.getPassword());
        String email = firebaseAuthRequest.getEmail();

        User user = new User();
        user.setEmail(email);


        userRepositorio.save(user);
    }

    @PostMapping("/login")
    public TokenResponse autenticaUsuarioFirebase(@RequestBody LoginRequest firebaseAuthRequest) throws Exception {
        firebaseService.login(firebaseAuthRequest.getEmail(), firebaseAuthRequest.getPassword());
        UserDetails userEmail = jwtUserDetailsService.loadUserByUsername(firebaseAuthRequest.getEmail());
        String token = jwtTokenUtil.generateToken(userEmail);
        return new TokenResponse(token);

    }
}