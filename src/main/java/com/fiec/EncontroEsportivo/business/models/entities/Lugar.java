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
}