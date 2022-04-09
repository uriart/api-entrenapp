package com.grupo.apirest.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EjerciciosEnum {

    /* The ejercicios */
    EJERCICIO_PESO_MUERTO("A", "Peso muerto"),
    EJERCICIO_SENTADILLA("B", "Sentadilla"),
    EJERCICIO_PRESS_BANCA("C", "Press banca"),
    EJERCICIO_DOMINADAS_LASTRADAS("D", "Dominadas lastradas"),
    EJERCICIO_ELEVACION_LATERAL("E", "Elevación lateral de mancuerna"),
    EJERCICIO_REMO_BARRA("F", "Remo con barra"),
    EJERCICIO_DOMINADAS_INVERSO("I", "Dominadas agarre inverso"),
    EJERCICIO_JALON_PECHO("J", "Jalón al pecho"),
    EJERCICIO_PRESS_MILITAR("M", "Press militar"),
    EJERCICIO_PRESS_PIE("P", "Press mancuerna de pie"),
    EJERCICIO_REMO_MANCUERNA("R", "Remo con mancuerna"),
    EJERCICIO_PRESS_SENTADO("S", "Press mancuerna sentado"),
    EJERCICIO_VARIACION_PESO_MUERTO("V", "Variación de peso muerto"),
    EJERCICIO_REMO_MAQUINA("X", "Remo con máquina"),
    EJERCICIO_OPCIONAL_1("1", "Opcional 1"),
    EJERCICIO_OPCIONAL_2("2", "Opcional 2"),
    EJERCICIO_OPCIONAL_TREN_INFERIOR("3", "Opcional tren inferior");

    private String code;
    private String value;

    EjerciciosEnum(String code, String value){
        this.code = code;
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
       return String.valueOf(value);
    }

    @JsonCreator
    public static EjerciciosEnum fromCode(String text) {
        for (EjerciciosEnum b : EjerciciosEnum.values()){
            if (String.valueOf(b.code).equals(text)){
                return b;
            }
        }
        return null;
    }

    @JsonCreator
    public static EjerciciosEnum fromValue(String text) {
        for (EjerciciosEnum b : EjerciciosEnum.values()){
            if (String.valueOf(b.value).equals(text)){
                return b;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

}
