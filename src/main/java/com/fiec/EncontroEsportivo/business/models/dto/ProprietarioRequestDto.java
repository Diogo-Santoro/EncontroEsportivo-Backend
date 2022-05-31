package com.fiec.EncontroEsportivo.business.models.dto;

import lombok.Data;

@Data
public class ProprietarioRequestDto {
    private String password;
    private String email;
    private String nome;
    private String telefone;
    private String cnpj;
}
