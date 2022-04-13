package com.grupo.apirest.entity.powerlifting;

import com.grupo.apirest.enums.EjerciciosEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public @Data
class ProgramaPowerliftingModel {
    private String titulo;
    private SemanaModel[] semana;

    public ProgramaPowerliftingModel(){
        super();
    }

    /* Constructor para generar el programa */
    public ProgramaPowerliftingModel(MarcasModel marcas){
        ArrayList<SemanaModel> listaSemanas = new ArrayList<>();
        listaSemanas.add(crearSemana1(marcas));
        listaSemanas.add(crearSemana2(marcas));
        listaSemanas.add(crearSemana3(marcas));
        listaSemanas.add(crearSemana4(marcas));
        listaSemanas.add(crearSemana5(marcas));
        listaSemanas.add(crearSemana6());
        this.semana = listaSemanas.toArray(new SemanaModel[listaSemanas.size()]);
        this.titulo = "Programa Powerlifting 6 semanas";
    }

    private SemanaModel crearSemana1(MarcasModel marcas){
        SemanaModel semana1 = new SemanaModel();
        semana1.setDescripcion("Acondicionamiento Muscular");

        ArrayList<DiaModel> listaDias = new ArrayList<>();
        DiaModel dia1= new DiaModel();
        dia1.setFechaDia(marcas.getFechaInicio());
        ArrayList<EjercicioModel> listaEjerciciosDia1 = new ArrayList<>();
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_SENTADILLA.getCode(), new Integer[] {80,80,80,80}, new String [] {"x6","x6","x6","x6"}, marcas.getSentadilla()));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PESO_MUERTO.getCode(), new Integer[] {80,80}, new String [] {"x6","x6"}, marcas.getPesoMuerto()));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        dia1.setEjercicios(listaEjerciciosDia1.toArray(new EjercicioModel[listaEjerciciosDia1.size()]));
        listaDias.add(dia1);

        DiaModel dia2= new DiaModel();
        dia2.setFechaDia(sumarDias(marcas.getFechaInicio(), 1));
        ArrayList<EjercicioModel> listaEjerciciosDia2 = new ArrayList<>();
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PRESS_BANCA.getCode(), new Integer[] {50,65,75,77}, new String [] {"x10","x10","x8","x6"}, marcas.getPressBanca()));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoEspalda1(), new Integer[0], new String [] {"x10","x10","x8","x6"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoHombro(), new Integer[0], new String [] {"x12","x12","x10","x8"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoEspalda2(), new Integer[0], new String [] {"x12","x12","x10","x8"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        dia2.setEjercicios(listaEjerciciosDia2.toArray(new EjercicioModel[listaEjerciciosDia2.size()]));
        listaDias.add(dia2);

        DiaModel dia3 = new DiaModel();
        dia3.setFechaDia(sumarDias(marcas.getFechaInicio(), 3));
        //El dia 3 es idéntico al dia 2
        dia3.setEjercicios(listaEjerciciosDia2.toArray(new EjercicioModel[5]));
        listaDias.add(dia3);

        DiaModel dia4 = new DiaModel();
        dia4.setFechaDia(sumarDias(marcas.getFechaInicio(), 4));
        ArrayList<EjercicioModel> listaEjerciciosDia4 = new ArrayList<>();
        listaEjerciciosDia4.add(crearEjercicio(EjerciciosEnum.EJERCICIO_SENTADILLA.getCode(), new Integer [] {70,70,70,70}, new String [] {"x8","x8","x8","x8"}, marcas.getSentadilla()));
        listaEjerciciosDia4.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PESO_MUERTO.getCode(), new Integer [] {70,70}, new String [] {"x8","x8"}, marcas.getPesoMuerto()));
        listaEjerciciosDia4.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(),  new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia4.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(),  new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        dia4.setEjercicios(listaEjerciciosDia4.toArray(new EjercicioModel[listaEjerciciosDia4.size()]));
        listaDias.add(dia4);

        DiaModel dia5 = new DiaModel();
        dia5.setFechaDia(sumarDias(marcas.getFechaInicio(), 5));
        ArrayList<EjercicioModel> listaEjerciciosDia5 = new ArrayList<>();
        listaEjerciciosDia5.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PRESS_BANCA.getCode(), new Integer [] {80}, new String [] {"MR"}, marcas.getPressBanca()));
        listaEjerciciosDia5.add(crearEjercicio(marcas.getCodigoEspalda1(), new Integer[0], new String [] {"x10","x10","x8","x6"}, 0));
        listaEjerciciosDia5.add(crearEjercicio(marcas.getCodigoHombro(), new Integer[0], new String [] {"x12","x12","x10","x8"}, 0));
        listaEjerciciosDia5.add(crearEjercicio(marcas.getCodigoEspalda2(), new Integer[0], new String [] {"x12","x12","x10","x8"}, 0));
        listaEjerciciosDia5.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia5.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        dia5.setEjercicios(listaEjerciciosDia5.toArray(new EjercicioModel[listaEjerciciosDia5.size()]));
        listaDias.add(dia5);

        semana1.setDias( listaDias.toArray(new DiaModel[listaDias.size()]) );
        return semana1;
    }


    private SemanaModel crearSemana2(MarcasModel marcas) {
        SemanaModel semana2 = new SemanaModel();
        semana2.setDescripcion("Hipertrofia Muscular");
        ArrayList<DiaModel> listaDias = new ArrayList<>();
        DiaModel dia1 = new DiaModel();
        dia1.setFechaDia(sumarDias(marcas.getFechaInicio(), 7));
        ArrayList<EjercicioModel> listaEjerciciosDia1 = new ArrayList<>();
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_SENTADILLA.getCode(), new Integer[] {80}, new String[] {"MR10"}, marcas.getSentadilla()));
        listaEjerciciosDia1.add(filaInformativa(marcas.getSentadilla(), "info1"));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_VARIACION_PESO_MUERTO.getCode(), new Integer[0], new String [] {"x8","x8","x8"}, marcas.getPesoMuerto()));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));

        dia1.setEjercicios(listaEjerciciosDia1.toArray(new EjercicioModel[listaEjerciciosDia1.size()]));
        listaDias.add(dia1);

        DiaModel dia2 = new DiaModel();
        dia2.setFechaDia(sumarDias(marcas.getFechaInicio(), 8));
        ArrayList<EjercicioModel> listaEjerciciosDia2 = new ArrayList<>();
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PRESS_BANCA.getCode(), new Integer[] {72,77,80}, new String [] {"x10","x8","x6-8"}, marcas.getPressBanca()));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoEspalda1(), new Integer[0], new String [] {"x10","x8","x8"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoHombro(), new Integer[0], new String [] {"x10","x8","x6"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoEspalda2(), new Integer[0], new String [] {"x10","x8","x6"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        dia2.setEjercicios(listaEjerciciosDia2.toArray(new EjercicioModel[listaEjerciciosDia2.size()]));
        listaDias.add(dia2);

        DiaModel dia3 = new DiaModel();
        dia3.setFechaDia(sumarDias(marcas.getFechaInicio(), 10));
        ArrayList<EjercicioModel> listaEjerciciosDia3 = new ArrayList<>();
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_SENTADILLA.getCode(), new Integer[] {83}, new String [] {"MR10"}, marcas.getSentadilla()));
        listaEjerciciosDia3.add(filaInformativa(marcas.getSentadilla(), "info2"));
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_VARIACION_PESO_MUERTO.getCode(), new Integer[0], new String [] {"x8","x8","x8"}, marcas.getPesoMuerto()));
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));

        dia3.setEjercicios(listaEjerciciosDia3.toArray(new EjercicioModel[listaEjerciciosDia3.size()]));
        listaDias.add(dia3);

        DiaModel dia4 = new DiaModel();
        dia4.setFechaDia(sumarDias(marcas.getFechaInicio(), 11));
        //Idéntico al dia 2
        dia4.setEjercicios(listaEjerciciosDia2.toArray(new EjercicioModel[listaEjerciciosDia2.size()]));
        listaDias.add(dia4);

        DiaModel dia5 = new DiaModel();
        dia5.setFechaDia(sumarDias(marcas.getFechaInicio(), 13));
        ArrayList<EjercicioModel> listaEjerciciosDia5 = new ArrayList<>();
        listaEjerciciosDia5.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PRESS_BANCA.getCode(), new Integer[] {83}, new String [] {"MR"}, marcas.getPressBanca()));
        listaEjerciciosDia5.add(crearEjercicio(marcas.getCodigoEspalda1(), new Integer[0], new String [] {"x10","x8","x8"}, 0));
        listaEjerciciosDia5.add(crearEjercicio(marcas.getCodigoHombro(), new Integer[0], new String [] {"x10","x8","x6"}, 0));
        listaEjerciciosDia5.add(crearEjercicio(marcas.getCodigoEspalda2(), new Integer[0], new String [] {"x10","x8","x6"}, 0));
        listaEjerciciosDia5.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia5.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        dia5.setEjercicios(listaEjerciciosDia5.toArray(new EjercicioModel[listaEjerciciosDia5.size()]));
        listaDias.add(dia5);

        semana2.setDias(listaDias.toArray(new DiaModel[listaDias.size()]));
        return semana2;
    }

    private SemanaModel crearSemana3(MarcasModel marcas) {
        SemanaModel semana3 = new SemanaModel();
        semana3.setDescripcion("Max-OT");
        ArrayList<DiaModel> listaDias = new ArrayList<>();
        DiaModel dia1 = new DiaModel();
        dia1.setFechaDia(sumarDias(marcas.getFechaInicio(), 14));

        ArrayList<EjercicioModel> listaEjerciciosDia1 = new ArrayList<>();
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_SENTADILLA.getCode(), new Integer[] {85, 85, 85}, new String [] {"x4-6","x4-6","x4-6"}, marcas.getSentadilla()));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PESO_MUERTO.getCode(), new Integer[] {87, 87}, new String [] {"x3-6", "x3-6"}, marcas.getPesoMuerto()));

        dia1.setEjercicios(listaEjerciciosDia1.toArray(new EjercicioModel[listaEjerciciosDia1.size()]));
        listaDias.add(dia1);

        DiaModel dia2 = new DiaModel();
        dia2.setFechaDia(sumarDias(marcas.getFechaInicio(), 16));
        ArrayList<EjercicioModel> listaEjerciciosDia2 = new ArrayList<>();
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PRESS_BANCA.getCode(), new Integer[] {85,85,85}, new String [] {"x4-6","x4-6","x4-6"}, marcas.getPressBanca()));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoEspalda1(), new Integer[0], new String [] {"x6","x6","x6"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoHombro(), new Integer[0], new String [] {"x6","x6","x6"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoEspalda2(), new Integer[0], new String [] {"x6","x6","x6"}, 0));
        dia2.setEjercicios(listaEjerciciosDia2.toArray(new EjercicioModel[listaEjerciciosDia2.size()]));
        listaDias.add(dia2);

        DiaModel dia3 = new DiaModel();
        dia3.setFechaDia(sumarDias(marcas.getFechaInicio(), 18));
        ArrayList<EjercicioModel> listaEjerciciosDia3 = new ArrayList<>();
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_SENTADILLA.getCode(), new Integer[] {88}, new String [] {"x4-6"}, marcas.getSentadilla()));
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PESO_MUERTO.getCode(), new Integer[0], new String [] {"x8"}, marcas.getPesoMuerto()));
        dia3.setEjercicios(listaEjerciciosDia3.toArray(new EjercicioModel[listaEjerciciosDia3.size()]));
        listaDias.add(dia3);

        DiaModel dia4 = new DiaModel();
        dia4.setFechaDia(sumarDias(marcas.getFechaInicio(), 19));
        ArrayList<EjercicioModel> listaEjerciciosDia4 = new ArrayList<>();
        listaEjerciciosDia4.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PRESS_BANCA.getCode(), new Integer[] {90,90,90}, new String [] {"x4-6","x4-6","x4-6"}, marcas.getPressBanca()));
        listaEjerciciosDia4.add(crearEjercicio(marcas.getCodigoEspalda1(), new Integer[0], new String [] {"x6","x6","x6"}, 0));
        listaEjerciciosDia4.add(crearEjercicio(marcas.getCodigoHombro(), new Integer[0], new String [] {"x6","x6","x6"}, 0));
        listaEjerciciosDia4.add(crearEjercicio(marcas.getCodigoEspalda2(), new Integer[0], new String [] {"x6","x6","x6"}, 0));
        dia4.setEjercicios(listaEjerciciosDia4.toArray(new EjercicioModel[listaEjerciciosDia4.size()]));
        listaDias.add(dia4);

        semana3.setDias(listaDias.toArray(new DiaModel[listaDias.size()]));
        return semana3;
    }

    private SemanaModel crearSemana4(MarcasModel marcas) {
        SemanaModel semana4 = new SemanaModel();
        semana4.setDescripcion("Aclimatación a altas cargas");
        ArrayList<DiaModel> listaDias = new ArrayList<>();
        DiaModel dia1 = new DiaModel();
        dia1.setFechaDia(sumarDias(marcas.getFechaInicio(), 21));

        ArrayList<EjercicioModel> listaEjerciciosDia1 = new ArrayList<>();
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_SENTADILLA.getCode(), new Integer[] {87, 90, 93}, new String [] {"x3","x3","x3"}, marcas.getSentadilla()));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PESO_MUERTO.getCode(), new Integer[0], new String [] {"x6", "x6"}, marcas.getPesoMuerto()));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));

        dia1.setEjercicios(listaEjerciciosDia1.toArray(new EjercicioModel[listaEjerciciosDia1.size()]));
        listaDias.add(dia1);

        DiaModel dia2 = new DiaModel();
        dia2.setFechaDia(sumarDias(marcas.getFechaInicio(), 22));
        ArrayList<EjercicioModel> listaEjerciciosDia2 = new ArrayList<>();
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PRESS_BANCA.getCode(), new Integer[] {87,90,92}, new String [] {"x3","x3","x3"}, marcas.getPressBanca()));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoEspalda2(), new Integer[0], new String [] {"x10","x10","x8","x6"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoHombro(), new Integer[0], new String [] {"x12","x12","x10","x8"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoEspalda2(), new Integer[0], new String [] {"x12","x12","x10","x8"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12","x8-12"}, 0));
        dia2.setEjercicios(listaEjerciciosDia2.toArray(new EjercicioModel[listaEjerciciosDia2.size()]));
        listaDias.add(dia2);

        DiaModel dia3 = new DiaModel();
        dia3.setFechaDia(sumarDias(marcas.getFechaInicio(), 24));
        ArrayList<EjercicioModel> listaEjerciciosDia3 = new ArrayList<>();
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_SENTADILLA.getCode(),  new Integer[] {92, 95}, new String [] {"x3","x1-2"}, marcas.getSentadilla()));
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PESO_MUERTO.getCode(),  new Integer[] {92, 95}, new String [] {"x3","x1-2"}, marcas.getPesoMuerto()));
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        dia3.setEjercicios(listaEjerciciosDia3.toArray(new EjercicioModel[listaEjerciciosDia3.size()]));
        listaDias.add(dia3);

        DiaModel dia4 = new DiaModel();
        dia4.setFechaDia(sumarDias(marcas.getFechaInicio(), 25));
        ArrayList<EjercicioModel> listaEjerciciosDia4 = new ArrayList<>();
        listaEjerciciosDia4.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PRESS_BANCA.getCode(), new Integer[] {87,90,95}, new String [] {"x3","x2-4","x1-2"}, marcas.getPressBanca()));
        listaEjerciciosDia4.add(crearEjercicio(marcas.getCodigoEspalda1(), new Integer[0], new String [] {"x10","x10","x8","x6"}, 0));
        listaEjerciciosDia4.add(crearEjercicio(marcas.getCodigoHombro(), new Integer[0], new String [] {"x12","x12","x10","x8"}, 0));
        listaEjerciciosDia4.add(crearEjercicio(marcas.getCodigoEspalda2(), new Integer[0], new String [] {"x12","x12","x10","x8"}, 0));
        listaEjerciciosDia4.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia4.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        dia4.setEjercicios(listaEjerciciosDia4.toArray(new EjercicioModel[listaEjerciciosDia4.size()]));
        listaDias.add(dia4);

        semana4.setDias(listaDias.toArray(new DiaModel[listaDias.size()]));
        return semana4;
    }

    private SemanaModel crearSemana5(MarcasModel marcas) {
        SemanaModel semana5 = new SemanaModel();
        semana5.setDescripcion("Fuerza / Alta intensidad");
        ArrayList<DiaModel> listaDias = new ArrayList<>();
        DiaModel dia1 = new DiaModel();
        dia1.setFechaDia(sumarDias(marcas.getFechaInicio(), 28));

        ArrayList<EjercicioModel> listaEjerciciosDia1 = new ArrayList<>();
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_SENTADILLA.getCode(), new Integer[] {97}, new String [] {"x1-4"}, marcas.getSentadilla()));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PESO_MUERTO.getCode(), new Integer[] {70, 73, 76}, new String [] {"x4", "x4", "x2"}, marcas.getPesoMuerto()));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_TREN_INFERIOR.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia1.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_TREN_INFERIOR.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));

        dia1.setEjercicios(listaEjerciciosDia1.toArray(new EjercicioModel[listaEjerciciosDia1.size()]));
        listaDias.add(dia1);

        DiaModel dia2 = new DiaModel();
        dia2.setFechaDia(sumarDias(marcas.getFechaInicio(), 30));
        ArrayList<EjercicioModel> listaEjerciciosDia2 = new ArrayList<>();
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PRESS_BANCA.getCode(), new Integer[] {97}, new String [] {"x1-4"}, marcas.getPressBanca()));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoEspalda1(), new Integer[0], new String [] {"x8","x6","x6"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoHombro(), new Integer[0], new String [] {"x8","x6","x6"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(marcas.getCodigoEspalda2(), new Integer[0], new String [] {"x8","x6","x6"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_1.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia2.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_2.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        dia2.setEjercicios(listaEjerciciosDia2.toArray(new EjercicioModel[listaEjerciciosDia2.size()]));
        listaDias.add(dia2);

        DiaModel dia3 = new DiaModel();
        dia3.setFechaDia(sumarDias(marcas.getFechaInicio(), 32));
        ArrayList<EjercicioModel> listaEjerciciosDia3 = new ArrayList<>();
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_PESO_MUERTO.getCode(), new Integer[] {97}, new String [] {"x1-4"}, marcas.getPesoMuerto()));
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_TREN_INFERIOR.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        listaEjerciciosDia3.add(crearEjercicio(EjerciciosEnum.EJERCICIO_OPCIONAL_TREN_INFERIOR.getCode(), new Integer[0], new String [] {"x8-12","x8-12","x8-12"}, 0));
        dia3.setEjercicios(listaEjerciciosDia3.toArray(new EjercicioModel[listaEjerciciosDia3.size()]));
        listaDias.add(dia3);
        semana5.setDias(listaDias.toArray(new DiaModel[listaDias.size()]));

        return semana5;
    }

    private SemanaModel crearSemana6() {
        SemanaModel semana6 = new SemanaModel();
        semana6.setDescripcion("Fin del programa");
        return semana6;
    }

    private EjercicioModel crearEjercicio(String codigoEjercicio, Integer[] pesos, String[] reps, Integer maxima){
        EjercicioModel ejercicio = new EjercicioModel();
        ArrayList<SeriesModel> listaSeries = new ArrayList<>();
        ejercicio.setNombreEjercicio(EjerciciosEnum.fromCode(codigoEjercicio).toString());

        for (Integer i = 0; i < reps.length; i++) {
            SeriesModel serie = new SeriesModel();
            serie.setRepeticiones(" "+reps[i]);
            if(!Arrays.asList(pesos).isEmpty()){
                serie.setPeso(calcularPeso(maxima, pesos[i]));
            }
            listaSeries.add(serie);
        }
        ejercicio.setSeries(listaSeries.toArray(new SeriesModel[listaSeries.size()]));
        return ejercicio;
    }

    private EjercicioModel filaInformativa(Integer maximaSentadilla, String numMensajeInfo){
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

    private Date sumarDias(Date fecha, Integer dias){
        if (dias==0) return fecha;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }

    private String calcularPeso(Integer value, Integer porcentaje) {
        Integer calculo = (value * porcentaje) / 100;
        String pesoRedondeado = String.valueOf(Math.round(calculo));
        return pesoRedondeado + "kg";
    }

}
