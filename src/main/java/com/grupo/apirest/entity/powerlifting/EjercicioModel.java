package com.grupo.apirest.entity.powerlifting;

import lombok.Data;

public @Data
class EjercicioModel {
    private String nombreEjercicio;
    private SeriesModel[] series;
}
