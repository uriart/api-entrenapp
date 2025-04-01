package com.grupo.apirest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo.apirest.controller.PowerProgramRestController;
import com.grupo.apirest.entity.Marcas;
import com.grupo.apirest.service.IPowerProgramService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;
import java.util.TimeZone;

public class BaseClassTest {

    @Autowired
    private IPowerProgramService powerProgramService;

    public MockMvc mvc;

    public String mapToJson(Object object) {
        String json = "";
        ObjectMapper ow = new ObjectMapper();
        ow.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));
        ow.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            json = ow.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        PowerProgramRestController powerProgramRestController = new PowerProgramRestController();
        ReflectionTestUtils.setField(powerProgramRestController, "powerProgramService", powerProgramService);
        mvc = MockMvcBuilders.standaloneSetup(powerProgramRestController).build();
    }

    protected Marcas initMarcas(){
        Marcas marcas = new Marcas();
        marcas.setCodigoEspalda1("A");
        marcas.setCodigoEspalda2("B");
        marcas.setCodigoHombro("C");
        marcas.setFechaInicio(new Date());
        marcas.setPesoMuerto(1);
        marcas.setPressBanca(1);
        marcas.setSentadilla(1);
        marcas.setUsuario("user1");
        return marcas;
    }
}
