package com.grupo.apirest.dao;

import com.grupo.apirest.entity.MarcasModel;

public interface IPowerProgramDAO {

    public MarcasModel saveMarcas(MarcasModel marcas);

    public MarcasModel findByUser(String user);
}
