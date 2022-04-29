
package com.fiec.EncontroEsportivo.business.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "proprietario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proprietario implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @ToString.Exclude
    @Column(unique = true)
    private String idProprietario;

    @OneToMany
    @JoinColumn(name = "idLugar")
    private Lugar lugar;

    /*@Column(unique = true)
    @JoinColumn(name = "Lugar", referencedColumnName = "idLugar")
    private String idLugar;*/



    @Column(unique = true)
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String cnpj;
}

