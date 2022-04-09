package com.grupo.apirest.entity.powerlifting;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grupo.apirest.util.ConstantsUtils;
import lombok.Data;

import java.util.Date;

public @Data
class DiaModel {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ConstantsUtils.FORMATO_FECHA)
    private Date fechaDia;
    private EjercicioModel[] ejercicios;
}
