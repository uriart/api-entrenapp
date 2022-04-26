package com.grupo.apirest.entity.program;

import lombok.Data;

public @Data
class SemanaModel {
    private String descripcion;
    private DiaModel[] dias;
}
