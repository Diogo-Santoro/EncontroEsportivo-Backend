package com.fiec.EncontroEsportivo.business.models.entities;

import com.fiec.EncontroEsportivo.business.models.dto.UsuarioListedResponse;
import com.google.firebase.database.annotations.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
  @Table(name = "evento")
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
 public class Evento implements Serializable {

    @Id
    @GeneratedValue (generator = "uuid", strategy= GenerationType.AUTO)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @ToString.Exclude
    @NotNull
    @Column(unique = true)
    private String idEvento;



//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name= "id_lugar")
//    private Lugar lugar;



//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_usuario")
//    private Usuario usuario;



    @NotNull
    private String nomeEvento;
    @NotNull
    private String dataHoraInicio;
    @NotNull
    private String dataHoraFim;

//    @OneToMany(mappedBy = "evento", fetch = FetchType.LAZY)
//    private List<UsuarioListedResponse> participantes = new ArrayList<>();





//   "usuario": {"id": "b1df9270-9bd4-4987-bf55-e037be5245ee"},
//    "lugar": {"id":"4ccd8c15-540d-49fa-963a-e458d05f1387"},
// "nomeEvento": "encontrinho dos cria",
//    "dataHoraInicio": "2022-05-20 00:00",
//    "dataHoraFim": "2020-05-20 00:30",
//    "participantes": "igor",
//    "cep": "123456"


}
