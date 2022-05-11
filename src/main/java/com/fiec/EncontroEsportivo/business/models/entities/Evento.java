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
  @Table(name = "evento")
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
 public class Evento implements Serializable {
    @Id
    @GeneratedValue (generator = "uuid", strategy= GenerationType.AUTO)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @ToString.Exclude
    @NotNull
    @Column(unique = true)
    private String idEvento;



    @OneToOne
    @JoinColumn(name= "idLugar")
    private Lugar lugar;



    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;



    @NotNull
    private String nomeEvento;
    @NotNull
    private Date dataHoraInicio;
    @NotNull
    private Date dataHoraFim;
    private String participantes;






}
