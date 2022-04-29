package com.fiec.EncontroEsportivo.business.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "avaliacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Avaliacao implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @ToString.Exclude
    @Column(unique = true)
    private String idAvaliacao;


    /*@Column(unique = true)
    @JoinColumn(name = "Usuario", referencedColumnName = "idUsuario")
    private String idUsuario;*/

    @OneToMany
    @JoinColumn(name= "idUsuario")
    private Usuario usuario;


    private int avaliacao;
}
