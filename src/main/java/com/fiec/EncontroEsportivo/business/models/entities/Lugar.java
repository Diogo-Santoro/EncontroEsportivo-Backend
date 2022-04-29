package com.fiec.EncontroEsportivo.business.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

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
    @Column(unique = true)


    private String nomeLugar;
    private String esporteDisp;
    private String descricao;
    private float valor;
    private String rua;
    private int CEP;
    private String bairro;
    private int numero;
    private String disponibilidade;
}
