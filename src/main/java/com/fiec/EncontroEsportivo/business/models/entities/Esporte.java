package com.fiec.EncontroEsportivo.business.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "esporte")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Esporte implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(unique = true)
    private String idEsporte;


    /*@Column(unique = true)
    @JoinColumn(name = "Usuario", referencedColumnName = "idUsuario")
    private String idUsuario;*/
    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;


    /*@Column(unique = true)
    @JoinColumn(name = "Lugar", referencedColumnName = "idLugar")
    private String idLugar;*/
    @OneToOne
    @JoinColumn(name = "idLugar")
    private Lugar lugar;


    private String nome;
    private Date dataEhora;
    private String esporteCategoria;
}
