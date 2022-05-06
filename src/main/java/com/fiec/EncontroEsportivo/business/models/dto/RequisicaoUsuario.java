package com.fiec.EncontroEsportivo.business.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RequisicaoUsuario {
    String nome;
    String email;
    String password;
    String rua;
    String telefone;
    String bairro;
    String nomeUsuario;
    String cep;
    String esporteFav;
    String profileImage;


}
