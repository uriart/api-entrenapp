package com.grupo.apirest.entity;

import com.grupo.apirest.enums.EjerciciosEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="MARCAS")
public @Data
class MarcasModel {

    @Id
    @Column(name="USUARIO")
    private String usuario;

    @Column(name="CO_HOMBRO")
    private String codigoHombro;

    private String descripcionHombro;

    @Column(name="CO_ESPALDA1")
    private String codigoEspalda1;

    private String descripcionEspalda1;

    @Column(name="CO_ESPALDA2")
    private String codigoEspalda2;

    private String descripcionEspalda2;

    @Column(name="PESO_MUERTO")
    private Integer pesoMuerto;

    @Column(name="PRESS_BANCA")
    private Integer pressBanca;

    @Column(name="SENTADILLA")
    private Integer sentadilla;

    @Column(name="FECHA_INICIO")
    private Date fechaInicio;

    public MarcasModel() {}

    public String getDescripcionHombro (){
        return EjerciciosEnum.valueOf(this.codigoHombro).name();
    }

    public String getDescripcionEspalda1 (){
        return EjerciciosEnum.valueOf(this.codigoEspalda1).name();
    }

    public String getDescripcionEspalda2 (){
        return EjerciciosEnum.valueOf(this.codigoEspalda2).name();
    }
}
