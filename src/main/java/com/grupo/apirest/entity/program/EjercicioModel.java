package com.grupo.apirest.entity.program;

import lombok.Data;

public @Data
class EjercicioModel {
    private String nombreEjercicio;
    private SeriesModel[] series;
}
