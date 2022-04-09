package com.grupo.apirest.service;

import com.grupo.apirest.entity.powerlifting.MarcasModel;
import com.grupo.apirest.entity.powerlifting.ProgramaPowerliftingModel;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IPowerProgramService {

	MarcasModel saveMarcas(MarcasModel marcas);
	MarcasModel getMarcasByUser(String user);
	ProgramaPowerliftingModel getProgram(String user);
}