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
}

//      Teste:
//{
//        "bairro": "jardim bairro",
//        "cep": "13344450",
//        "nomeUsuario": "diogo",
//        "esporteFav": "volei"
//
//        }

// Token teste
//eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkaW9nb3Rlc3RlQG1haWwuY29tIiwiZXhwIjoxNjUzNzA4MDUzLCJpYXQiOjE2NTM2OTAwNTN9.4wZHobGxHdXORHCgC6qkP_R_W3pNkJUdIfxH1t2pUiNRhu6GFjRHeltt1jjWU6m1puil7VFzgfhxX4qat49e5w