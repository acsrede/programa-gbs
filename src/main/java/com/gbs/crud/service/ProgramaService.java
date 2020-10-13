package com.gbs.crud.service;

import com.gbs.crud.domain.Programa;
import com.gbs.crud.domain.model.response.ResponsePrograma;
import com.gbs.crud.repository.ProgramaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProgramaService {

    private final ProgramaRepository programaRepository;

    public ResponseEntity<Programa> create(Programa programa) {
        if (programa.getId().toUpperCase() == null || programa.getId().isEmpty()) {
            String[] name = programa.getNome().split(" ");
            var sizeName = name.length;
            programa.setId(
                (name[0].substring(0, (name[0].length()==4
                        ?name[0].length()-3
                        :(name[0].length()==5
                        ?name[0].length()-4
                        :name[0].length()-5)))) +
                (name[sizeName-1].substring(0, name[sizeName-1].length()))
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(programaRepository.save(programa));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    public List<Optional<Programa>> findAll() {
        return programaRepository.findAllByActive();
    }

    public ResponseEntity<ResponsePrograma> search(String id) {
        return programaRepository.findById(id.toUpperCase())
                .map(record -> ResponseEntity.ok(ResponsePrograma.builder()
                        .nome(nameInverter(record.getNome()))
                        .build()))
                .orElse(ResponseEntity.ok(ResponsePrograma.builder().build()));
    }

    public ResponseEntity<Programa> update(String id, Programa programa) {
        return programaRepository.findById(id.toUpperCase())
                .map(record -> ResponseEntity.ok(programaRepository.save(programa)))
                .orElse(ResponseEntity.notFound().build());
    }

    public void delete(String id) {
        programaRepository.findById(id.toUpperCase())
                .map(record -> {
                    record.setAtivo(0);
                    record.setData_exclusao(LocalDateTime.now());
                    programaRepository.save(record);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public static String nameInverter(String nome) {
        return new StringBuilder(nome).reverse().toString().trim();
    }



}
