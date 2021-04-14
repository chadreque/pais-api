package com.chadreque.software.paisapi.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@XmlRootElement
@EqualsAndHashCode
public class Pais implements Serializable {

    @Id
    @Getter
//    @GeneratedValue(strategy = GenerationType.AUTO)  Se usar Mysql descomenta essa linha
    //Para estrategia de geracao de chave automatica no Postgresql,
    @GeneratedValue(generator = "increment") //comenta essa linha se estiver a usar Mysql
    @GenericGenerator(name = "increment", strategy = "increment") //comenta essa linha se estiver a usar Mysql
    private Long id;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Column(unique = true, length = 60)
    private String nome;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Column(unique = true, length = 60)
    private String capital;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Column(length = 60)
    private String regiao;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Column(length = 60)
    private String subRegiao;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Column(length = 60)
    private String area;

    @Getter
    @Setter
    private Date dataRegisto;

    @Getter
    @Setter
    private Date dataAlteracao;

    public void setDate() {
        if(id == null) {
            dataRegisto = new Date();
        } else {
            dataAlteracao = new Date();
        }
    }
}
