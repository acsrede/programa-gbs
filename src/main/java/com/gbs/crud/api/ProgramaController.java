package com.gbs.crud.api;

import com.gbs.crud.domain.Programa;
import com.gbs.crud.domain.model.response.ResponsePrograma;
import com.gbs.crud.service.ProgramaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class ProgramaController {

    private final ProgramaService programaService;

    @PostMapping(path = "/programa")
    public ResponseEntity<Programa> create(@RequestBody Programa programa) {
        return programaService.create(programa);
    }

    @GetMapping(path = "/programa")
    public ResponseEntity<List<Optional<Programa>>> getAll() {
        return ResponseEntity.ok(programaService.findAll());
    }

    @GetMapping(path = "/programa/{id}")
    public ResponseEntity<ResponsePrograma> search(@PathVariable("id") String id) {
        return programaService.search(id);
    }

    @PutMapping(path = "/programa/{id}")
    public ResponseEntity<Programa> update(@PathVariable("id") String id,
                                           @RequestBody Programa programa) {
        return programaService.update(id, programa);
    }

    @DeleteMapping(path = "/programa/{id}")
    public void delete(@PathVariable("id") String id) {
        programaService.delete(id);
    }


}
