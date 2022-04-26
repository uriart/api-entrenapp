package com.grupo.apirest.dao.repository;

import com.grupo.apirest.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PowerProgramRepository extends JpaRepository<Nota, Long> {

    @Query(value = "SELECT e.id, e.usuario, e.nota FROM TNOTAS e WHERE USUARIO = ?1", nativeQuery = true)
    List<Nota> getNotasByUser(String user);

}
