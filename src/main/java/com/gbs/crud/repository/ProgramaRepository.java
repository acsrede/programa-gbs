package com.gbs.crud.repository;

import com.gbs.crud.domain.Programa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProgramaRepository extends JpaRepository<Programa, String> {

    @Query(nativeQuery = false, value = "SELECT PRG FROM Programa PRG WHERE PRG.ativo = 1")
    List<Optional<Programa>> findAllByActive();

}
