package com.grupo.apirest.controller;

import com.grupo.apirest.entity.powerlifting.MarcasModel;
import com.grupo.apirest.entity.powerlifting.ProgramaPowerliftingModel;
import com.grupo.apirest.service.IPowerProgramService;
import com.grupo.apirest.util.SwaggerConfigurationConstants;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/powerlifting", produces = MediaType.APPLICATION_JSON_VALUE)
public class PowerProgramRestController {

    @Autowired
    private IPowerProgramService powerProgramService;

    @ApiOperation(value = SwaggerConfigurationConstants.POST_MARCAS_USER)
    @PostMapping("/marcas")
    public MarcasModel saveMarcas(@RequestBody MarcasModel marcas){
        return powerProgramService.saveMarcas(marcas);
    }

    @ApiOperation(value = SwaggerConfigurationConstants.GET_MARCAS_USER)
    @GetMapping("/marcas")
    public MarcasModel getMarcas(String user) throws NotFoundException {
        MarcasModel marcas = powerProgramService.getMarcasByUser(user);
        return marcas;
    }

    @ApiOperation(value = SwaggerConfigurationConstants.GET_PROGRAMA)
    @GetMapping("/program")
    public ProgramaPowerliftingModel getProgram(String user){
        return powerProgramService.getProgram(user);
    }

}
