package com.fiec.EncontroEsportivo.business.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String nome;
    private String email;
    private String password;
    private String nomeUsuario;
    private String cep;
    private String bairro;
    private String esporteFav;

}

//{ nome: "", nomeUsuario: "", senha: "", cep: "", rua: "", bairro: "", email: "", esporteFav: "", profileImage: "" }