package com.grupo.apirest.entity.program;

import com.grupo.apirest.entity.Marcas;
import com.grupo.apirest.enums.EjerciciosEnum;
import lombok.Data;

import java.util.*;

public @Data
class ProgramaPowerlifting {
    private String titulo;
    private SemanaModel[] semana;

    public ProgramaPowerlifting(){
        super();
    }

    /* Constructor para generar el programa */
    public ProgramaPowerlifting(Marcas marcas){
        List<SemanaModel> listaSemanas = new ArrayList<>();
        listaSemanas.add(crearSemana1(marcas));
        listaSemanas.add(crearSemana2(marcas));
        listaSemanas.add(crearSemana3(marcas));
        listaSemanas.add(crearSemana4(marcas));
        listaSemanas.add(crearSemana5(marcas));
        listaSemanas.add(crearSemana6());
        this.semana = listaSemanas.toArray(new SemanaModel[0]);
        this.titulo = "Programa Powerlifting 6 semanas";
    }

    private SemanaModel crearSemana1(Marcas marcas){
        SemanaModel semana1 = new SemanaModel();
        semana1.setDescripcion("Acondicionamiento Muscular");

        List<DiaModel> listaDias = new ArrayList<>();
        DiaModel dia1= new DiaModel();
        dia1.setFechaDia(marcas.getFechaInicio());
        List<EjercicioModel> listaEjerciciosDia1 = new ArrayList<>();
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_SENTADILLA.getCode(), new int[] {80,80,80,80}, new String [] {"x6","x6","x6","x6"}, marcas.getSentadilla()));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PESO_MUERTO.getCode(), new int[] {80,80}, new String [] {"x6","x6"}, marcas.getPesoMuerto()));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        dia1.setEjercicios(listaEjerciciosDia1.toArray(new EjercicioModel[0]));
        listaDias.add(dia1);

        DiaModel dia2= new DiaModel();
        dia2.setFechaDia(sumarDias(marcas.getFechaInicio(), 1));
        List<EjercicioModel> listaEjerciciosDia2 = new ArrayList<>();
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PRESS_BANCA.getCode(), new int[] {50,65,75,77}, new String [] {"x10","x10","x8","x6"}, marcas.getPressBanca()));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoEspalda1(), new int[0], new String [] {"x10","x10","x8","x6"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoHombro(), new int[0], new String [] {"x12","x12","x10","x8"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoEspalda2(), new int[0], new String [] {"x12","x12","x10","x8"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        dia2.setEjercicios(listaEjerciciosDia2.toArray(new EjercicioModel[0]));
        listaDias.add(dia2);

        DiaModel dia3 = new DiaModel();
        dia3.setFechaDia(sumarDias(marcas.getFechaInicio(), 3));
        //El dia 3 es idéntico al dia 2
        dia3.setEjercicios(listaEjerciciosDia2.toArray(new EjercicioModel[5]));
        listaDias.add(dia3);

        DiaModel dia4 = new DiaModel();
        dia4.setFechaDia(sumarDias(marcas.getFechaInicio(), 4));
        List<EjercicioModel> listaEjerciciosDia4 = new ArrayList<>();
        listaEjerciciosDia4.add(crearEjercicio(EjerciciosEnum.EJERCICIO_SENTADILLA.getCode(), new int [] {70,70,70,70}, new String [] {"x8","x8","x8","x8"}, marcas.getSentadilla()));
        listaEjerciciosDia4.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PESO_MUERTO.getCode(), new int [] {70,70}, new String [] {"x8","x8"}, marcas.getPesoMuerto()));
        listaEjerciciosDia4.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(),  new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia4.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(),  new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        dia4.setEjercicios(listaEjerciciosDia4.toArray(new EjercicioModel[0]));
        listaDias.add(dia4);

        DiaModel dia5 = new DiaModel();
        dia5.setFechaDia(sumarDias(marcas.getFechaInicio(), 5));
        List<EjercicioModel> listaEjerciciosDia5 = new ArrayList<>();
        listaEjerciciosDia5.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PRESS_BANCA.getCode(), new int [] {80}, new String [] {"MR"}, marcas.getPressBanca()));
        listaEjerciciosDia5.add(crearEjercicio(marcas.getCodigoEspalda1(), new int[0], new String [] {"x10","x10","x8","x6"}, 0));
        listaEjerciciosDia5.add(crearEjercicio(marcas.getCodigoHombro(), new int[0], new String [] {"x12","x12","x10","x8"}, 0));
        listaEjerciciosDia5.add(crearEjercicio(marcas.getCodigoEspalda2(), new int[0], new String [] {"x12","x12","x10","x8"}, 0));
        listaEjerciciosDia5.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia5.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        dia5.setEjercicios(listaEjerciciosDia5.toArray(new EjercicioModel[0]));
        listaDias.add(dia5);

        semana1.setDias( listaDias.toArray(new DiaModel[0]) );
        return semana1;
    }


    private SemanaModel crearSemana2(Marcas marcas) {
        SemanaModel semana2 = new SemanaModel();
        semana2.setDescripcion("Hipertrofia Muscular");
        List<DiaModel> listaDias = new ArrayList<>();
        DiaModel dia1 = new DiaModel();
        dia1.setFechaDia(sumarDias(marcas.getFechaInicio(), 7));
        List<EjercicioModel> listaEjerciciosDia1 = new ArrayList<>();
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_SENTADILLA.getCode(), new int[] {80}, new String[] {"MR10"}, marcas.getSentadilla()));
        listaEjerciciosDia1.add(filaInformativa(marcas.getSentadilla(), "info1"));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_VARIACION_PESO_MUERTO.getCode(), new int[0], new String [] {"x8","x8","x8"}, marcas.getPesoMuerto()));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));

        dia1.setEjercicios(listaEjerciciosDia1.toArray(new EjercicioModel[0]));
        listaDias.add(dia1);

        DiaModel dia2 = new DiaModel();
        dia2.setFechaDia(sumarDias(marcas.getFechaInicio(), 8));
        List<EjercicioModel> listaEjerciciosDia2 = new ArrayList<>();
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PRESS_BANCA.getCode(), new int[] {72,77,80}, new String [] {"x10","x8","x6-8"}, marcas.getPressBanca()));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoEspalda1(), new int[0], new String [] {"x10","x8","x8"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoHombro(), new int[0], new String [] {"x10","x8","x6"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoEspalda2(), new int[0], new String [] {"x10","x8","x6"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        dia2.setEjercicios(listaEjerciciosDia2.toArray(new EjercicioModel[0]));
        listaDias.add(dia2);

        DiaModel dia3 = new DiaModel();
        dia3.setFechaDia(sumarDias(marcas.getFechaInicio(), 10));
        List<EjercicioModel> listaEjerciciosDia3 = new ArrayList<>();
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_SENTADILLA.getCode(), new int[] {83}, new String [] {"MR10"}, marcas.getSentadilla()));
        listaEjerciciosDia3.add(filaInformativa(marcas.getSentadilla(), "info2"));
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_VARIACION_PESO_MUERTO.getCode(), new int[0], new String [] {"x8","x8","x8"}, marcas.getPesoMuerto()));
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));

        dia3.setEjercicios(listaEjerciciosDia3.toArray(new EjercicioModel[0]));
        listaDias.add(dia3);

        DiaModel dia4 = new DiaModel();
        dia4.setFechaDia(sumarDias(marcas.getFechaInicio(), 11));
        //Idéntico al dia 2
        dia4.setEjercicios(listaEjerciciosDia2.toArray(new EjercicioModel[0]));
        listaDias.add(dia4);

        DiaModel dia5 = new DiaModel();
        dia5.setFechaDia(sumarDias(marcas.getFechaInicio(), 13));
        List<EjercicioModel> listaEjerciciosDia5 = new ArrayList<>();
        listaEjerciciosDia5.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PRESS_BANCA.getCode(), new int[] {83}, new String [] {"MR"}, marcas.getPressBanca()));
        listaEjerciciosDia5.add(crearEjercicio(marcas.getCodigoEspalda1(), new int[0], new String [] {"x10","x8","x8"}, 0));
        listaEjerciciosDia5.add(crearEjercicio(marcas.getCodigoHombro(), new int[0], new String [] {"x10","x8","x6"}, 0));
        listaEjerciciosDia5.add(crearEjercicio(marcas.getCodigoEspalda2(), new int[0], new String [] {"x10","x8","x6"}, 0));
        listaEjerciciosDia5.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia5.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        dia5.setEjercicios(listaEjerciciosDia5.toArray(new EjercicioModel[0]));
        listaDias.add(dia5);

        semana2.setDias(listaDias.toArray(new DiaModel[0]));
        return semana2;
    }

    private SemanaModel crearSemana3(Marcas marcas) {
        SemanaModel semana3 = new SemanaModel();
        semana3.setDescripcion("Max-OT");
        List<DiaModel> listaDias = new ArrayList<>();
        DiaModel dia1 = new DiaModel();
        dia1.setFechaDia(sumarDias(marcas.getFechaInicio(), 14));

        List<EjercicioModel> listaEjerciciosDia1 = new ArrayList<>();
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_SENTADILLA.getCode(), new int[] {85, 85, 85}, new String [] {"x4-6","x4-6","x4-6"}, marcas.getSentadilla()));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PESO_MUERTO.getCode(), new int[] {87, 87}, new String [] {"x3-6", "x3-6"}, marcas.getPesoMuerto()));

        dia1.setEjercicios(listaEjerciciosDia1.toArray(new EjercicioModel[0]));
        listaDias.add(dia1);

        DiaModel dia2 = new DiaModel();
        dia2.setFechaDia(sumarDias(marcas.getFechaInicio(), 16));
        List<EjercicioModel> listaEjerciciosDia2 = new ArrayList<>();
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PRESS_BANCA.getCode(), new int[] {85,85,85}, new String [] {"x4-6","x4-6","x4-6"}, marcas.getPressBanca()));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoEspalda1(), new int[0], new String [] {"x6","x6","x6"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoHombro(), new int[0], new String [] {"x6","x6","x6"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoEspalda2(), new int[0], new String [] {"x6","x6","x6"}, 0));
        dia2.setEjercicios(listaEjerciciosDia2.toArray(new EjercicioModel[0]));
        listaDias.add(dia2);

        DiaModel dia3 = new DiaModel();
        dia3.setFechaDia(sumarDias(marcas.getFechaInicio(), 18));
        List<EjercicioModel> listaEjerciciosDia3 = new ArrayList<>();
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_SENTADILLA.getCode(), new int[] {88}, new String [] {"x4-6"}, marcas.getSentadilla()));
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PESO_MUERTO.getCode(), new int[0], new String [] {"x8"}, marcas.getPesoMuerto()));
        dia3.setEjercicios(listaEjerciciosDia3.toArray(new EjercicioModel[0]));
        listaDias.add(dia3);

        DiaModel dia4 = new DiaModel();
        dia4.setFechaDia(sumarDias(marcas.getFechaInicio(), 19));
        List<EjercicioModel> listaEjerciciosDia4 = new ArrayList<>();
        listaEjerciciosDia4.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PRESS_BANCA.getCode(), new int[] {90,90,90}, new String [] {"x4-6","x4-6","x4-6"}, marcas.getPressBanca()));
        listaEjerciciosDia4.add(crearEjercicio(marcas.getCodigoEspalda1(), new int[0], new String [] {"x6","x6","x6"}, 0));
        listaEjerciciosDia4.add(crearEjercicio(marcas.getCodigoHombro(), new int[0], new String [] {"x6","x6","x6"}, 0));
        listaEjerciciosDia4.add(crearEjercicio(marcas.getCodigoEspalda2(), new int[0], new String [] {"x6","x6","x6"}, 0));
        dia4.setEjercicios(listaEjerciciosDia4.toArray(new EjercicioModel[0]));
        listaDias.add(dia4);

        semana3.setDias(listaDias.toArray(new DiaModel[0]));
        return semana3;
    }

    private SemanaModel crearSemana4(Marcas marcas) {
        SemanaModel semana4 = new SemanaModel();
        semana4.setDescripcion("Aclimatación a altas cargas");
        List<DiaModel> listaDias = new ArrayList<>();
        DiaModel dia1 = new DiaModel();
        dia1.setFechaDia(sumarDias(marcas.getFechaInicio(), 21));

        List<EjercicioModel> listaEjerciciosDia1 = new ArrayList<>();
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_SENTADILLA.getCode(), new int[] {87, 90, 93}, new String [] {"x3","x3","x3"}, marcas.getSentadilla()));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PESO_MUERTO.getCode(), new int[0], new String [] {"x6", "x6"}, marcas.getPesoMuerto()));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));

        dia1.setEjercicios(listaEjerciciosDia1.toArray(new EjercicioModel[0]));
        listaDias.add(dia1);

        DiaModel dia2 = new DiaModel();
        dia2.setFechaDia(sumarDias(marcas.getFechaInicio(), 22));
        List<EjercicioModel> listaEjerciciosDia2 = new ArrayList<>();
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PRESS_BANCA.getCode(), new int[] {87,90,92}, new String [] {"x3","x3","x3"}, marcas.getPressBanca()));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoEspalda2(), new int[0], new String [] {"x10","x10","x8","x6"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoHombro(), new int[0], new String [] {"x12","x12","x10","x8"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoEspalda2(), new int[0], new String [] {"x12","x12","x10","x8"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12","x8-12"}, 0));
        dia2.setEjercicios(listaEjerciciosDia2.toArray(new EjercicioModel[0]));
        listaDias.add(dia2);

        DiaModel dia3 = new DiaModel();
        dia3.setFechaDia(sumarDias(marcas.getFechaInicio(), 24));
        List<EjercicioModel> listaEjerciciosDia3 = new ArrayList<>();
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_SENTADILLA.getCode(),  new int[] {92, 95}, new String [] {"x3","x1-2"}, marcas.getSentadilla()));
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PESO_MUERTO.getCode(),  new int[] {92, 95}, new String [] {"x3","x1-2"}, marcas.getPesoMuerto()));
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        dia3.setEjercicios(listaEjerciciosDia3.toArray(new EjercicioModel[0]));
        listaDias.add(dia3);

        DiaModel dia4 = new DiaModel();
        dia4.setFechaDia(sumarDias(marcas.getFechaInicio(), 25));
        List<EjercicioModel> listaEjerciciosDia4 = new ArrayList<>();
        listaEjerciciosDia4.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PRESS_BANCA.getCode(), new int[] {87,90,95}, new String [] {"x3","x2-4","x1-2"}, marcas.getPressBanca()));
        listaEjerciciosDia4.add(crearEjercicio(marcas.getCodigoEspalda1(), new int[0], new String [] {"x10","x10","x8","x6"}, 0));
        listaEjerciciosDia4.add(crearEjercicio(marcas.getCodigoHombro(), new int[0], new String [] {"x12","x12","x10","x8"}, 0));
        listaEjerciciosDia4.add(crearEjercicio(marcas.getCodigoEspalda2(), new int[0], new String [] {"x12","x12","x10","x8"}, 0));
        listaEjerciciosDia4.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia4.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        dia4.setEjercicios(listaEjerciciosDia4.toArray(new EjercicioModel[0]));
        listaDias.add(dia4);

        semana4.setDias(listaDias.toArray(new DiaModel[0]));
        return semana4;
    }

    private SemanaModel crearSemana5(Marcas marcas) {
        SemanaModel semana5 = new SemanaModel();
        semana5.setDescripcion("Fuerza / Alta intensidad");
        List<DiaModel> listaDias = new ArrayList<>();
        DiaModel dia1 = new DiaModel();
        dia1.setFechaDia(sumarDias(marcas.getFechaInicio(), 28));

        List<EjercicioModel> listaEjerciciosDia1 = new ArrayList<>();
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_SENTADILLA.getCode(), new int[] {97}, new String [] {"x1-4"}, marcas.getSentadilla()));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PESO_MUERTO.getCode(), new int[] {70, 73, 76}, new String [] {"x4", "x4", "x2"}, marcas.getPesoMuerto()));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_TREN_INFERIOR.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_TREN_INFERIOR.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));

        dia1.setEjercicios(listaEjerciciosDia1.toArray(new EjercicioModel[0]));
        listaDias.add(dia1);

        DiaModel dia2 = new DiaModel();
        dia2.setFechaDia(sumarDias(marcas.getFechaInicio(), 30));
        List<EjercicioModel> listaEjerciciosDia2 = new ArrayList<>();
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PRESS_BANCA.getCode(), new int[] {97}, new String [] {"x1-4"}, marcas.getPressBanca()));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoEspalda1(), new int[0], new String [] {"x8","x6","x6"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoHombro(), new int[0], new String [] {"x8","x6","x6"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoEspalda2(), new int[0], new String [] {"x8","x6","x6"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        dia2.setEjercicios(listaEjerciciosDia2.toArray(new EjercicioModel[0]));
        listaDias.add(dia2);

        DiaModel dia3 = new DiaModel();
        dia3.setFechaDia(sumarDias(marcas.getFechaInicio(), 32));
        List<EjercicioModel> listaEjerciciosDia3 = new ArrayList<>();
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PESO_MUERTO.getCode(), new int[] {97}, new String [] {"x1-4"}, marcas.getPesoMuerto()));
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_TREN_INFERIOR.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_TREN_INFERIOR.getCode(), new int[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        dia3.setEjercicios(listaEjerciciosDia3.toArray(new EjercicioModel[0]));
        listaDias.add(dia3);
        semana5.setDias(listaDias.toArray(new DiaModel[0]));

        return semana5;
    }

    private SemanaModel crearSemana6() {
        SemanaModel semana6 = new SemanaModel();
        semana6.setDescripcion("Fin del programa");
        return semana6;
    }

    private EjercicioModel crearEjercicio(String codigoEjercicio, int[] pesos, String[] reps, int maxima){
        EjercicioModel ejercicio = new EjercicioModel();
        ArrayList<SeriesModel> listaSeries = new ArrayList<>();
        ejercicio.setNombreEjercicio(EjerciciosEnum.fromCode(codigoEjercicio).toString());

        for (int i = 0; i < 4; i++) {
            SeriesModel serie = new SeriesModel();
            if(reps.length > i) {
                serie.setRepeticiones(" " + reps[i]);
            }
            if(pesos.length > i){
                serie.setPeso(calcularPeso(maxima, pesos[i]));
            }
            listaSeries.add(serie);
        }
        ejercicio.setSeries(listaSeries.toArray(new SeriesModel[0]));
        return ejercicio;
    }

    private EjercicioModel filaInformativa(int maximaSentadilla, String numMensajeInfo){
        EjercicioModel ejercicio = new EjercicioModel();
        ejercicio.setNombreEjercicio("colspan5");
        ArrayList<SeriesModel> listaSeries = new ArrayList<>();
        SeriesModel serie = new SeriesModel();
        serie.setPeso(calcularPeso(maximaSentadilla, 5));
        serie.setRepeticiones(numMensajeInfo);
        listaSeries.add(serie);
        ejercicio.setSeries(listaSeries.toArray(new SeriesModel[1]));
        return ejercicio;
    }

    private Date sumarDias(Date fecha, int dias){
        if (dias==0) return fecha;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }

    private String calcularPeso(int value, int porcentaje) {
        int calculo = (value * porcentaje) / 100;
        String pesoRedondeado = String.valueOf(Math.round(calculo));
        return pesoRedondeado + "kg";
    }

}
