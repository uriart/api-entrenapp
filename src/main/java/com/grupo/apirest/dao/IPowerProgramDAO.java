package com.grupo.apirest.dao;

import com.grupo.apirest.entity.Marcas;
import com.grupo.apirest.entity.Nota;

import java.util.List;
import java.util.Optional;

public interface IPowerProgramDAO {

    Marcas saveMarcas(Marcas marcas);

    Marcas findByUser(String user);

    List<Nota> getNotesByUser(String user);

    Optional<Nota> getNoteById(Long id);

    void saveNota(Nota nota);

}
