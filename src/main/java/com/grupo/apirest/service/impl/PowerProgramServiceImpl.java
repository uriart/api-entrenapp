package com.grupo.apirest.service.impl;

import com.grupo.apirest.dao.IPowerProgramDAO;
import com.grupo.apirest.entity.MarcasModel;
import com.grupo.apirest.entity.programa.ProgramaPowerliftingModel;
import com.grupo.apirest.service.IPowerProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PowerProgramServiceImpl implements IPowerProgramService {

    @Autowired
    private IPowerProgramDAO powerProgramDAO;

    @Override
    public MarcasModel saveMarcas(MarcasModel marcas) {
        return powerProgramDAO.saveMarcas(marcas);
    }

    @Override
    public MarcasModel getMarcasByUser(String user) {
        return powerProgramDAO.findByUser(user);
    }

    @Override
    public ProgramaPowerliftingModel getProgram(String user) {
        MarcasModel marcas = getMarcasByUser(user);
        //TODO impl generar programa
        return new ProgramaPowerliftingModel(marcas);
    }




}
