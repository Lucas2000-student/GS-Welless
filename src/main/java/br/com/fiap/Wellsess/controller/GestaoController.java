package br.com.fiap.Wellsess.controller;

import br.com.fiap.Wellsess.dto.GestaoRequestDTO;
import br.com.fiap.Wellsess.dto.GestaoResponseDTO;
import br.com.fiap.Wellsess.service.GestaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/gestores")
public class GestaoController {

    @Autowired
    private GestaoService gestaoService;

    @GetMapping
    public ResponseEntity<List<GestaoResponseDTO>> findAll() {
        List<GestaoResponseDTO> gestores = gestaoService.findAll();
        return ResponseEntity.ok(gestores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GestaoResponseDTO> findById(@PathVariable Long id) {
        GestaoResponseDTO gestor = gestaoService.findById(id);
        return ResponseEntity.ok(gestor);
    }

    @PostMapping
    public ResponseEntity<GestaoResponseDTO> create(@Valid @RequestBody GestaoRequestDTO dto) {
        GestaoResponseDTO gestor = gestaoService.create(dto);
        return ResponseEntity.ok(gestor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GestaoResponseDTO> update(@Valid @PathVariable Long id, @RequestBody GestaoRequestDTO dto) {
        GestaoResponseDTO gestor = gestaoService.update(id, dto);
        return ResponseEntity.ok(gestor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        gestaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}