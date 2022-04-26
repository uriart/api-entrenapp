package com.grupo.apirest.controller;

import com.grupo.apirest.entity.Marcas;
import com.grupo.apirest.entity.Nota;
import com.grupo.apirest.entity.program.ProgramaPowerlifting;
import com.grupo.apirest.service.IPowerProgramService;
import com.grupo.apirest.util.SwaggerConfigurationConstants;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/powerlifting", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class PowerProgramRestController {

    @Autowired
    private IPowerProgramService powerProgramService;

    @ApiOperation(value = SwaggerConfigurationConstants.POST_MARCAS_USER)
    @PostMapping(value = "/marcas", produces = MediaType.APPLICATION_JSON_VALUE)
    public Marcas saveMarcas(@RequestBody Marcas marcas){
        return powerProgramService.saveMarcas(marcas);
    }

    @ApiOperation(value = SwaggerConfigurationConstants.GET_MARCAS_USER)
    @GetMapping("/marcas")
    public Marcas getMarcas(String user) {
        return powerProgramService.getMarcasByUser(user);
    }

    @ApiOperation(value = SwaggerConfigurationConstants.GET_PROGRAMA)
    @GetMapping(value = "/program", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProgramaPowerlifting getProgram(String user) throws NotFoundException {
        return powerProgramService.getProgram(user);
    }

    @ApiOperation("")
    @GetMapping(value = "/getNotesByUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Nota> getNotesByUser(String user){
        return powerProgramService.getNotesByUser(user);
    }

    @ApiOperation("")
    @GetMapping(value = "/getNoteById", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Nota> getNoteById(Long id){
        return powerProgramService.getNoteById(id);
    }

    @ApiOperation("")
    @PostMapping(value = "/saveNota", produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveNota(@RequestBody Nota nota){
        powerProgramService.saveNota(nota);
    }

}
