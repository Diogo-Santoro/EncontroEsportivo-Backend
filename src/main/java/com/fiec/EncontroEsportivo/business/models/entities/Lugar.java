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
@Table(name = "lugar")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lugar implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @ToString.Exclude
    @Column(unique = true)
    private String idLugar;


    private String nomeLugar;

    private String descricao;


    private float valor;

    private String rua;

    private String cep;

    private String bairro;

    private int numero;

    private String disponibilidade;

    private float lat;

    private float lng;


}

/*{
      "nomeLugar": "Cruzeiro treinos",
        "valor": "0.5",
        "rua": "Rua doidõe",
        "cep": 1,
        "bairro": "jardim esquisito",
        "numero": 200,
        "lat": -23.09625771114854,
        "lng": -47.23066920083178
        }*/