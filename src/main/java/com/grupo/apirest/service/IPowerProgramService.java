package com.grupo.apirest.service;

import com.grupo.apirest.entity.Marcas;
import com.grupo.apirest.entity.Nota;
import com.grupo.apirest.entity.program.ProgramaPowerlifting;
import javassist.NotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface IPowerProgramService {

	Marcas saveMarcas(Marcas marcas);
	Marcas getMarcasByUser(String user);
	ProgramaPowerlifting getProgram(String user) throws NotFoundException;
	List<Nota> getNotesByUser(String user);
	Optional<Nota> getNoteById(Long id);
	void saveNota(Nota nota);
	void deleteNota(Long id);
}