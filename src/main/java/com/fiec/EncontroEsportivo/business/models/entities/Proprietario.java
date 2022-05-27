
package com.fiec.EncontroEsportivo.business.models.entities;

import com.google.firebase.database.annotations.NotNull;
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


    @ManyToOne
    @JoinColumn(name = "id_lugar")
    private Lugar lugar;

    private String nome;

    private String telefone;

    private String cnpj;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;
}

