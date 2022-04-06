package com.grupo.apirest.service;

import com.grupo.apirest.entity.MarcasModel;
import com.grupo.apirest.entity.programa.ProgramaPowerliftingModel;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IPowerProgramService {

	MarcasModel saveMarcas(MarcasModel marcas);
	MarcasModel getMarcasByUser(String user);
	ProgramaPowerliftingModel getProgram(String user);
}