package com.grupo.apirest.entity.program;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grupo.apirest.util.Constantes;
import lombok.Data;

import java.util.Date;

public @Data
class DiaModel {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constantes.FORMATO_FECHA_LOCAL)
    private Date fechaDia;
    private EjercicioModel[] ejercicios;
}
