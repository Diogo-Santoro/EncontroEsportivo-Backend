package com.fiec.EncontroEsportivo.business.models.controllers;

import com.fiec.EncontroEsportivo.business.models.Utils.JwtTokenUtil;
import com.fiec.EncontroEsportivo.business.models.dto.FirebaseAuthRequest;
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
    public void registraUsuarioFirebase(@RequestBody FirebaseAuthRequest firebaseAuthRequest) throws Exception {
        firebaseService.register(firebaseAuthRequest);
        String email = firebaseAuthRequest.getEmail();
        String password = firebaseAuthRequest.getPassword();
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userRepositorio.save(user);
    }

    @PostMapping("/login")
    public TokenResponse autenticaUsuarioFirebase(@RequestBody FirebaseAuthRequest firebaseAuthRequest) throws Exception {
        firebaseService.login(firebaseAuthRequest);
        UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(firebaseAuthRequest.getEmail());
        String token = jwtTokenUtil.generateToken(userDetails);
        return new TokenResponse(token);

    }
}