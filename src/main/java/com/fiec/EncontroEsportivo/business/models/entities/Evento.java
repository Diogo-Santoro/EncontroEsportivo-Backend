package com.fiec.EncontroEsportivo.business.models.entities;


import com.fiec.EncontroEsportivo.business.models.dto.UsuarioListedRequest;
import com.google.firebase.database.annotations.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
  @Table(name = "evento")
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
 public class Evento implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @ToString.Exclude
    @NotNull
    @Column(unique = true)
    private String idEvento;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_lugar")
    private Lugar lugar;

    private String nomeEvento;

    private String dataHoraInicio;

    private String dataHoraFim;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User user;


    @ManyToMany
    @JoinTable(name = "participa", joinColumns = {@JoinColumn(name = "id_evento")}, inverseJoinColumns = {@JoinColumn(name = "id_usuario")})
    private List<Usuario> participantes = new ArrayList<>();



}

