package com.fiec.EncontroEsportivo.business.models.dto;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UsuarioResponse {
    String nome;
    String email;
    String password;
    String rua;
    String bairro;
    String nomeUsuario;
    String cep;
    String esporteFav;
    String profileImage;

}
