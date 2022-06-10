package com.fiec.EncontroEsportivo.business.models.dto;

import com.fiec.EncontroEsportivo.EsporteEnum;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder

public class LugarResponseDto {
    private String idLugar;


    private String nomeLugar;

    private String descricao;

    private float valor;

    private String rua;

    private String cep;

    private String bairro;

    private int numero;

    private String disponibilidade;

    private float lat;

    private float lng;

    List<EsporteEnum> esportes;


}
