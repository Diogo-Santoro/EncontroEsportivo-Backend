package com.fiec.EncontroEsportivo.business.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
  @Table(name = "evento")
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
 public class Evento implements Serializable {
    @Id
    @GeneratedValue (generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @ToString.Exclude
    @Column(unique = true)
    private String idEvento;


    /*@Column(unique = true)
    @JoinColumn(name = "Lugar", referencedColumnName = "idUugar")
    private String idLugar;*/
    @OneToOne
    @JoinColumn(name= "idLugar")
    private Lugar lugar;


    /*@Column(unique=true)
    @JoinColumn(name = "Usuario", referencedColumnName = "idUsuario")
    private String idUsuario;*/
    @OneToMany
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;


    /*@Column(unique = true)
    @JoinColumn(name = "Esporte", referencedColumnName = "idEsporte")
    private String idEsporte;*/
    @OneToOne
    @JoinColumn(name= "idEsporte")
    private Esporte esporte;
}
