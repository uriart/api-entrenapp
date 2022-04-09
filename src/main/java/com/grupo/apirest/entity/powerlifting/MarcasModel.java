package com.grupo.apirest.entity.powerlifting;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grupo.apirest.enums.EjerciciosEnum;
import com.grupo.apirest.util.ConstantsUtils;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="TMARCAS")
public @Data
class MarcasModel {

    @Id
    @Column(name="USUARIO")
    private String usuario;

    @Column(name="CO_HOMBRO")
    private String codigoHombro;

    @Transient
    private String descripcionHombro;

    @Column(name="CO_ESPALDA1")
    private String codigoEspalda1;

    @Transient
    private String descripcionEspalda1;

    @Column(name="CO_ESPALDA2")
    private String codigoEspalda2;

    @Transient
    private String descripcionEspalda2;

    @Column(name="PESO_MUERTO")
    private Integer pesoMuerto;

    @Column(name="PRESS_BANCA")
    private Integer pressBanca;

    @Column(name="SENTADILLA")
    private Integer sentadilla;

    @Column(name="FECHA_INICIO")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ConstantsUtils.FORMATO_FECHA)
    private Date fechaInicio;

    public MarcasModel() {}

    public String getDescripcionHombro (){
        return EjerciciosEnum.fromCode(this.codigoHombro).toString();
    }

    public String getDescripcionEspalda1 (){
        return EjerciciosEnum.fromCode(this.codigoEspalda1).toString();
    }

    public String getDescripcionEspalda2 (){
        return EjerciciosEnum.fromCode(this.codigoEspalda2).toString();
    }
}
