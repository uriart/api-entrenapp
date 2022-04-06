package com.grupo.apirest.entity.programa;

import lombok.Data;

public @Data
class SemanaModel {
    private String descripcion;
    private DiaModel[] dias;
}
