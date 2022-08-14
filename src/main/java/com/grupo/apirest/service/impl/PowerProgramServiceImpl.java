package com.grupo.apirest.service.impl;

import com.grupo.apirest.dao.IPowerProgramDAO;
import com.grupo.apirest.entity.Marcas;
import com.grupo.apirest.entity.Nota;
import com.grupo.apirest.entity.program.ProgramaPowerlifting;
import com.grupo.apirest.exception.ApiRequestException;
import com.grupo.apirest.service.IPowerProgramService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PowerProgramServiceImpl implements IPowerProgramService {

    @Autowired
    private IPowerProgramDAO powerProgramDAO;

    @Override
    public Marcas saveMarcas(Marcas marcas) {
        return powerProgramDAO.saveMarcas(marcas);
    }

    @Override
    public Marcas getMarcasByUser(String user) {
        return Optional.ofNullable(powerProgramDAO.findByUser(user))
                .orElseThrow(() -> new ApiRequestException("No se encuentra el usuario " + user));
    }

    @Override
    public ProgramaPowerlifting getProgram(String user){
        Marcas marcas = getMarcasByUser(user);
        return new ProgramaPowerlifting(marcas);
    }

    @Override
    public List<Nota> getNotesByUser(String user) {
        return powerProgramDAO.getNotesByUser(user);
    }

    @Override
    public Optional<Nota> getNoteById(Long id) {
        return powerProgramDAO.getNoteById(id);
    }

    @Override
    public void saveNota(Nota nota) {
        powerProgramDAO.saveNota(nota);
    }

    @Override
    public void deleteNota(Long id) {
        powerProgramDAO.deleteNota(id);
    }


}
