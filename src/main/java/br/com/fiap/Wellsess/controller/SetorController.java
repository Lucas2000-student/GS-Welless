package br.com.fiap.Wellsess.controller;

import br.com.fiap.Wellsess.dto.SetorRequestDTO;
import br.com.fiap.Wellsess.dto.SetorResponseDTO;
import br.com.fiap.Wellsess.service.SetorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/setores")
@Tag(name = "Setores", description = "Gerenciamento de setores da empresa")
public class SetorController {

    @Autowired
    private SetorService setorService;

    @GetMapping
    public ResponseEntity<List<SetorResponseDTO>> findAll() {
        List<SetorResponseDTO> setores = setorService.findAll();
        return ResponseEntity.ok(setores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SetorResponseDTO> findById(@PathVariable Long id) {
        SetorResponseDTO setor = setorService.findById(id);
        return ResponseEntity.ok(setor);
    }

    @PostMapping
    public ResponseEntity<SetorResponseDTO> create(@Valid @RequestBody SetorRequestDTO dto) {
        SetorResponseDTO setor = setorService.create(dto);
        return ResponseEntity.ok(setor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SetorResponseDTO> update(@PathVariable Long id, @Valid @RequestBody SetorRequestDTO dto) {
        SetorResponseDTO setor = setorService.update(id, dto);
        return ResponseEntity.ok(setor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        setorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}