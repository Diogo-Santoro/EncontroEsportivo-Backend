package com.fiec.EncontroEsportivo.business.models.dto;

import com.fiec.EncontroEsportivo.EsporteEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data

public class LugarRequestDto {
    List<EsporteEnum> esportes = new ArrayList<>();

    private String nomeLugar;

    private String descricao;

    private String cep;

    private int numero;

    private String disponibilidade;

    private float lat;

    private float lng;

    private String idEvento;




}
