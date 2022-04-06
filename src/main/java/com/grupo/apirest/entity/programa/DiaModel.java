package com.grupo.apirest.entity.programa;

import lombok.Data;

import java.util.Date;

public @Data
class DiaModel {
    private Date fechaDia;
    private EjercicioModel[] ejercicios;
}
