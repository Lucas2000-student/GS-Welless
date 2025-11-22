package br.com.fiap.Wellsess.controller;

import br.com.fiap.Wellsess.dto.CheckinHumorRequestDTO;
import br.com.fiap.Wellsess.dto.CheckinHumorResponseDTO;
import br.com.fiap.Wellsess.service.CheckinHumorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/checkins")
@Tag(name = "Checkins", description = "Gerenciamento de checkins de humor")
public class CheckinHumorController {

    @Autowired
    private CheckinHumorService checkinHumorService;

    @GetMapping
    @Operation(summary = "Listar todos os checkins", description = "Retorna todos os checkins de humor cadastrados")
    public ResponseEntity<List<CheckinHumorResponseDTO>> findAll() {
        List<CheckinHumorResponseDTO> checkins = checkinHumorService.findAll();
        return ResponseEntity.ok(checkins);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar checkin por ID", description = "Retorna um checkin específico pelo ID")
    public ResponseEntity<CheckinHumorResponseDTO> findById(@PathVariable Long id) {
        CheckinHumorResponseDTO checkin = checkinHumorService.findById(id);
        return ResponseEntity.ok(checkin);
    }

    @GetMapping("/usuario/{usuarioId}")
    @Operation(summary = "Buscar checkins por usuário", description = "Retorna todos os checkins de um usuário específico")
    public ResponseEntity<List<CheckinHumorResponseDTO>> findByUsuarioId(@PathVariable Long usuarioId) {
        List<CheckinHumorResponseDTO> checkins = checkinHumorService.findByUsuarioId(usuarioId);
        return ResponseEntity.ok(checkins);
    }

    @PostMapping
    @Operation(summary = "Criar checkin", description = "Cria um novo checkin de humor no sistema")
    public ResponseEntity<CheckinHumorResponseDTO> create(@Valid @RequestBody CheckinHumorRequestDTO dto) {
        CheckinHumorResponseDTO checkin = checkinHumorService.create(dto);
        return ResponseEntity.ok(checkin);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar checkin", description = "Atualiza os dados de um checkin existente")
    public ResponseEntity<CheckinHumorResponseDTO> update(@PathVariable Long id, @Valid @RequestBody CheckinHumorRequestDTO dto) {
        CheckinHumorResponseDTO checkin = checkinHumorService.update(id, dto);
        return ResponseEntity.ok(checkin);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar checkin", description = "Remove um checkin do sistema")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        checkinHumorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}