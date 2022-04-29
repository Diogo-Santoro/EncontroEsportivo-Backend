package com.fiec.EncontroEsportivo.business.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;

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


    private String nome;
    private String email;
    private String senha;
    private String rua;
    private String telefone;
    private String bairro;
    private String nomeUsuario;
    private String cep;
    private String esporteFav;
    private String profileImage;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id, nullable = false")
    private User user;
}
