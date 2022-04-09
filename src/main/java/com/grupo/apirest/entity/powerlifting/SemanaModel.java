package com.grupo.apirest.entity.powerlifting;

import lombok.Data;

public @Data
class SemanaModel {
    private String descripcion;
    private DiaModel[] dias;
}
