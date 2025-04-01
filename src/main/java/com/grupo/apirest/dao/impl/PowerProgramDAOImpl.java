package com.grupo.apirest.dao.impl;

import com.grupo.apirest.dao.IPowerProgramDAO;
import com.grupo.apirest.dao.repository.PowerProgramRepository;
import com.grupo.apirest.entity.Marcas;
import com.grupo.apirest.entity.Nota;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class PowerProgramDAOImpl implements IPowerProgramDAO {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private PowerProgramRepository powerProgramRepository;

    @Override
    public Marcas saveMarcas(Marcas marcas) {
        try(Session currentSession = entityManager.unwrap(Session.class)) {
            currentSession.saveOrUpdate(marcas);
        }
        return marcas;
    }

    @Override
    public Marcas findByUser(String user) {
        try(Session currentSession = entityManager.unwrap(Session.class)) {
            return currentSession.get(Marcas.class, user);
        }
    }

    @Override
    public List<Nota> getNotesByUser(String user) {
        return powerProgramRepository.getNotasByUser(user);
    }

    @Override
    public Optional<Nota> getNoteById(Long id) {
        return powerProgramRepository.findById(id);
    }

    @Override
    public void saveNota(Nota nota) {
        powerProgramRepository.save(nota);
    }

    @Override
    public void deleteNota(Long id) {
        powerProgramRepository.deleteById(id);
    }

}
