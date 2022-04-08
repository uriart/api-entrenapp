package com.grupo.apirest.entity.programa;

import lombok.Data;

public @Data
class EjercicioModel {
    private String nombreEjercicio;
    private SeriesModel[] series;
}
