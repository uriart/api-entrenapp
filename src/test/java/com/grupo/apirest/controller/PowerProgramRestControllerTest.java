package com.grupo.apirest.controller;

import com.grupo.apirest.BaseClassTest;
import com.grupo.apirest.dao.IPowerProgramDAO;
import com.grupo.apirest.entity.Marcas;
import com.grupo.apirest.entity.Nota;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@RunWith(SpringRunner.class)
@SpringBootTest
class PowerProgramRestControllerTest extends BaseClassTest {

    @MockBean
    private IPowerProgramDAO powerProgramDAO;
    private final String USUARIO = "user1";
    private final Long ID_NOTA = 1L;
    @Test
    void saveMarcas() {
        when(powerProgramDAO.saveMarcas(any(Marcas.class))).thenReturn(initMarcas());
        String url = "/powerlifting/marcas";
        try {
            mvc.perform(MockMvcRequestBuilders.post(url)
                .content(mapToJson(initMarcas()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void getMarcas() {
        when(powerProgramDAO.findByUser(eq(USUARIO))).thenReturn(initMarcas());
        String url = "/powerlifting/marcas";
        try {
            mvc.perform(MockMvcRequestBuilders.get(url)
                            .param("user", USUARIO)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void getProgram() {
        when(powerProgramDAO.findByUser(eq(USUARIO))).thenReturn(initMarcas());
        String url = "/powerlifting/program";
        try {
            mvc.perform(MockMvcRequestBuilders.get(url)
                            .param("user", USUARIO)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            fail();
        }

    }

    @Test
    void getNotesByUser() {
        when(powerProgramDAO.getNotesByUser(eq(USUARIO))).thenReturn( new ArrayList<>());
        String url = "/powerlifting/getNotesByUser";
        try {
            mvc.perform(MockMvcRequestBuilders.get(url)
                            .param("user", USUARIO)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void getNoteById() {
        when(powerProgramDAO.getNoteById(eq(ID_NOTA))).thenReturn( null );
        String url = "/powerlifting/getNoteById";
        try {
            mvc.perform(MockMvcRequestBuilders.get(url)
                            .param("id", ID_NOTA.toString())
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void saveNota() {
        String url = "/powerlifting/saveNota";
        try {
            mvc.perform(MockMvcRequestBuilders.post(url)
                            .content(mapToJson(new Nota()))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void deleteNota() {
        String url = "/powerlifting/deleteNota";
        try {
            mvc.perform(MockMvcRequestBuilders.delete(url)
                            .param("id", ID_NOTA.toString())
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            fail();
        }
    }



}