package com.fiec.EncontroEsportivo.business.models.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class EventoListedResponse {
    private String idUsuario;
    private String nomeUsuario;

}
