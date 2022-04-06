package com.grupo.apirest.entity.programa;

import com.grupo.apirest.entity.MarcasModel;
import lombok.Data;

public @Data
class ProgramaPowerliftingModel {
    private String titulo = "Programa Powerlifting 6 semanas";
    private SemanaModel[] semana;

    public ProgramaPowerliftingModel(){
        super();
    }

    /* Constructor para generar el programa */
    public ProgramaPowerliftingModel(MarcasModel marcas){

    }

}
