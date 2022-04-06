package com.grupo.apirest.dao.impl;

import com.grupo.apirest.dao.IPowerProgramDAO;
import com.grupo.apirest.entity.MarcasModel;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class PowerProgramDAOImpl implements IPowerProgramDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public MarcasModel saveMarcas(MarcasModel marcas) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(marcas);
        return marcas;
    }

    @Override
    public MarcasModel findByUser(String user) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(MarcasModel.class, user);
    }

}
