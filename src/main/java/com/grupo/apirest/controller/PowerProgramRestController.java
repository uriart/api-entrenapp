package com.grupo.apirest.controller;

import com.grupo.apirest.entity.MarcasModel;
import com.grupo.apirest.entity.programa.ProgramaPowerliftingModel;
import com.grupo.apirest.service.IPowerProgramService;
import com.grupo.apirest.util.SwaggerConfigurationConstants;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PowerProgramRestController extends APIBaseRestController{

    @Autowired
    private IPowerProgramService powerProgramService;

    @ApiOperation(value = SwaggerConfigurationConstants.POST_MARCAS_USER)
    @PostMapping("/marcas")
    public MarcasModel saveMarcas(@RequestBody MarcasModel marcas){
        return powerProgramService.saveMarcas(marcas);
    }

    @ApiOperation(value = SwaggerConfigurationConstants.GET_MARCAS_USER)
    @GetMapping("/marcas")
    public MarcasModel getMarcas(String user){
        return powerProgramService.getMarcasByUser(user);
    }

    @ApiOperation(value = SwaggerConfigurationConstants.GET_PROGRAMA)
    @GetMapping("/program")
    public ProgramaPowerliftingModel getProgram(String user){
        return powerProgramService.getProgram(user);
    }

}
