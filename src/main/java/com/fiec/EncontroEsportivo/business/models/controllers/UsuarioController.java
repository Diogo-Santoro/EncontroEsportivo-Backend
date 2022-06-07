package com.fiec.EncontroEsportivo.business.models.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fiec.EncontroEsportivo.business.models.dto.RequisicaoUsuario;
import com.fiec.EncontroEsportivo.business.models.dto.UsuarioImageRequest;
import com.fiec.EncontroEsportivo.business.models.entities.User;
import com.fiec.EncontroEsportivo.business.models.entities.Usuario;
import com.fiec.EncontroEsportivo.business.models.repositories.IUserRepositorio;
import com.fiec.EncontroEsportivo.business.models.repositories.IUsuarioRepositorio;
import com.fiec.EncontroEsportivo.business.models.services.IUsuarioService;
import net.coobird.thumbnailator.Thumbnails;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.UUID;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;


    @Autowired
    IUserRepositorio userRepositorio;

    @Autowired
    IUsuarioRepositorio usuarioRepositorio;



    @PostMapping
    public void saveUsuario(@RequestBody Usuario usuario){
        usuarioService.saveUsuario(usuario);
    }

    @GetMapping("/{idUsuario}")
    public Usuario pegaUsuario(@PathVariable("idUsuario") String idUsuario){

        return usuarioService.pegaUsuario(idUsuario);
    }

    @PutMapping("/{idUsuario}")
    public void atualizaUsuario(@PathVariable("idUsuario") String idUsuario, @RequestBody Usuario usuario){
        usuarioService.atualizaUsuario(usuario, idUsuario);
    }

    @DeleteMapping("/{idUsuario}")

    public void deletaUsuario(@PathVariable("idUsuario") String idUsuario){
        usuarioService.deletaUsuario(idUsuario);
    }


    /*@PutMapping(value = "/comFoto",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void atualizaUsuariocomFoto(@RequestParam("usuario") String usuario, @RequestParam("foto") MultipartFile file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        UsuarioImageRequest imagemUsuario = objectMapper.readValue(usuario, UsuarioImageRequest.class);
        Usuario usuario = usuarioRepositorio.findById(UsuarioImageRequest.getprofileImage()).orElse(null);
        imagemUsuario.setProfileImage(usuario);
        String profileImage = UUID.randomUUID() + "_" + Long.toHexString(new Date().getTime());
        imagemUsuario.setProfileImage(profileImage + ".jpg");
        usuarioService.saveUsuario(usuario);

        Path filename = Paths.get("uploads").resolve(profileImage);

        Path thumbFilename = Paths.get("uploads").resolve("thumb_" + profileImage);
        Thumbnails.of(file.getInputStream())
                .size(500, 500)
                .outputFormat("jpg")
                .toFile(new File(filename.toString()));
        Thumbnails.of(file.getInputStream())
                .size(100, 100)
                .outputFormat("jpg")
                .toFile(new File(thumbFilename.toString()));

    }*/

}