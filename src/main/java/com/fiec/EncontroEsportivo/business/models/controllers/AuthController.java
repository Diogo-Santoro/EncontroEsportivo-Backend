package com.fiec.EncontroEsportivo.business.models.controllers;

import com.fiec.EncontroEsportivo.business.models.Utils.JwtTokenUtil;
import com.fiec.EncontroEsportivo.business.models.dto.LoginRequest;
import com.fiec.EncontroEsportivo.business.models.dto.ProprietarioRequestDto;
import com.fiec.EncontroEsportivo.business.models.dto.RegisterRequest;
import com.fiec.EncontroEsportivo.business.models.dto.TokenResponse;
import com.fiec.EncontroEsportivo.business.models.entities.User;
import com.fiec.EncontroEsportivo.business.models.repositories.IUserRepositorio;
import com.fiec.EncontroEsportivo.business.models.services.IFirebaseService;
import com.fiec.EncontroEsportivo.business.models.services.IProprietarioService;
import com.fiec.EncontroEsportivo.business.models.services.JwtUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    IFirebaseService firebaseService;
    @Autowired
    IProprietarioService proprietarioService;

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
        log.info("Usuario registrado");
    }

    @PostMapping("/login")
    public TokenResponse autenticaUsuarioFirebase(@RequestBody LoginRequest firebaseAuthRequest) throws Exception {
        firebaseService.login(firebaseAuthRequest.getEmail(), firebaseAuthRequest.getPassword());
        UserDetails userEmail = jwtUserDetailsService.loadUserByUsername(firebaseAuthRequest.getEmail());
        String token = jwtTokenUtil.generateToken(userEmail);
        log.info("Usuario Logado, bem vindo{}", firebaseAuthRequest.getEmail());
        return new TokenResponse(token);
    }

    @PostMapping("/register/owner")

    public void registraProprietarioFirebase(@RequestBody ProprietarioRequestDto proprietario) throws Exception {
        firebaseService.register(proprietario.getEmail(), proprietario.getPassword());
        proprietarioService.saveProprietario(proprietario);
        log.info("Proprietario Cadastrado");
    }

}