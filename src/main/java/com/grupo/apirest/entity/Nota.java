package com.grupo.apirest.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="TNOTAS")
@Data
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="ID")
    private Long id;

    @Column(name="USUARIO")
    private String usuario;

    @Column(name="NOTA")
    private String nota;
}
