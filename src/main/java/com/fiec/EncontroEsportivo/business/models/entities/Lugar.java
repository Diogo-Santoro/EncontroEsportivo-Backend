package com.fiec.EncontroEsportivo.business.models.entities;

import com.google.firebase.database.annotations.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "lugar")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lugar implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @ToString.Exclude
    @Column(unique = true)
    private String idLugar;
    @Column(unique = true)

    @NotNull
    private String nomeLugar;

    private String descricao;

    @NotNull
    private float valor;
    @NotNull
    private String rua;
    @NotNull
    private int CEP;
    @NotNull
    private String bairro;
    @NotNull
    private int numero;
    @NotNull
    private Date disponibilidade;
    @NotNull
    private float lat;
    @NotNull
    private float lng;


}
