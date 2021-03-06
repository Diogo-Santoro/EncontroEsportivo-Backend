package com.fiec.EncontroEsportivo.business.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FirebaseAuthRequest {
    private String email;
    private String password;
    private boolean returnSecureToken;
}
