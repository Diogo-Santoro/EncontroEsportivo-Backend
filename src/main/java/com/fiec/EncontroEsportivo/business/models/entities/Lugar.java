package com.fiec.EncontroEsportivo.business.models.entities;

import com.fiec.EncontroEsportivo.EsporteEnum;
import com.google.firebase.database.annotations.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "lugar")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lugar implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @ToString.Exclude
    @Column(unique = true)
    private String idLugar;


    private String nomeLugar;

    private String descricao;

    private String cep;

    private int numero;

    private String disponibilidade;

    private float lat;

    private float lng;

    private String esporteDisp;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Evento> eventos = new ArrayList<>();

}