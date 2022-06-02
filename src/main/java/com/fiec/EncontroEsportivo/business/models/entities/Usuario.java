package com.fiec.EncontroEsportivo.business.models.entities;


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
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @ToString.Exclude
    @Column(unique = true)
    private String idUsuario;


    private String bairro;

    private String cep;

    private String nomeUsuario;

    private String esporteFav;

    private String profileImage;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User user;


    @ManyToMany
    @JoinTable(name = "participa", joinColumns = {@JoinColumn(name = "id_usuario")}, inverseJoinColumns = {@JoinColumn(name = "id_evento")})
    private List<Evento> participantes = new ArrayList<>();



}
