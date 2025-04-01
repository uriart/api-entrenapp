package com.grupo.apirest.controller;

import com.grupo.apirest.entity.Marcas;
import com.grupo.apirest.entity.Nota;
import com.grupo.apirest.entity.program.ProgramaPowerlifting;
import com.grupo.apirest.service.IPowerProgramService;
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

    @PostMapping(value = "/marcas", produces = MediaType.APPLICATION_JSON_VALUE)
    public Marcas saveMarcas(@RequestBody Marcas marcas){
        return powerProgramService.saveMarcas(marcas);
    }

    @GetMapping("/marcas")
    public Marcas getMarcas(String user) {
        return powerProgramService.getMarcasByUser(user);
    }

    @GetMapping(value = "/program", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProgramaPowerlifting getProgram(String user) {
        return powerProgramService.getProgram(user);
    }

    @GetMapping(value = "/getNotesByUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Nota> getNotesByUser(String user){
        return powerProgramService.getNotesByUser(user);
    }

    @GetMapping(value = "/getNoteById", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Nota> getNoteById(Long id){
        return powerProgramService.getNoteById(id);
    }

    @PostMapping(value = "/saveNota", produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveNota(@RequestBody Nota nota){
        powerProgramService.saveNota(nota);
    }

    @DeleteMapping(value = "/deleteNota", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteNota(Long id){
        powerProgramService.deleteNota(id);
    }

}
