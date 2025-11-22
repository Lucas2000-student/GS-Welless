package br.com.fiap.Wellsess.controller;

import br.com.fiap.Wellsess.dto.GestaoRequestDTO;
import br.com.fiap.Wellsess.dto.GestaoResponseDTO;
import br.com.fiap.Wellsess.service.GestaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/gestores")
@Tag(name = "Gestores", description = "Gerenciamento de gestores da empresa")
public class GestaoController {

    @Autowired
    private GestaoService gestaoService;

    @GetMapping
    @Operation(summary = "Listar todos os gestores", description = "Retorna todos os gestores cadastrados")
    public ResponseEntity<List<GestaoResponseDTO>> findAll() {
        List<GestaoResponseDTO> gestores = gestaoService.findAll();
        return ResponseEntity.ok(gestores);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar gestor por ID", description = "Retorna um gestor específico pelo ID")
    public ResponseEntity<GestaoResponseDTO> findById(@PathVariable Long id) {
        GestaoResponseDTO gestor = gestaoService.findById(id);
        return ResponseEntity.ok(gestor);
    }

    @PostMapping
    @Operation(summary = "Criar gestor", description = "Cria um novo gestor no sistema")
    public ResponseEntity<GestaoResponseDTO> create(@Valid @RequestBody GestaoRequestDTO dto) {
        GestaoResponseDTO gestor = gestaoService.create(dto);
        return ResponseEntity.ok(gestor);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar gestor", description = "Atualiza os dados de um gestor existente")
    public ResponseEntity<GestaoResponseDTO> update(@PathVariable Long id, @Valid @RequestBody GestaoRequestDTO dto) {
        GestaoResponseDTO gestor = gestaoService.update(id, dto);
        return ResponseEntity.ok(gestor);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar gestor", description = "Remove um gestor do sistema")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        gestaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}