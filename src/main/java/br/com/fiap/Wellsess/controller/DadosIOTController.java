package br.com.fiap.Wellsess.controller;

import br.com.fiap.Wellsess.dto.DadosIOTRequestDTO;
import br.com.fiap.Wellsess.dto.DadosIOTResponseDTO;
import br.com.fiap.Wellsess.service.DadosIOTService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dados-iot")
@Tag(name = "Dados IoT", description = "Gerenciamento de dados de sensores IoT")
public class DadosIOTController {

    @Autowired
    private DadosIOTService dadosIOTService;

    @GetMapping
    @Operation(summary = "Listar todos os dados IoT", description = "Retorna todos os dados de sensores cadastrados")
    public ResponseEntity<List<DadosIOTResponseDTO>> findAll() {
        List<DadosIOTResponseDTO> dados = dadosIOTService.findAll();
        return ResponseEntity.ok(dados);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar dados IoT por ID", description = "Retorna dados específicos de sensor pelo ID")
    public ResponseEntity<DadosIOTResponseDTO> findById(@PathVariable Long id) {
        DadosIOTResponseDTO dados = dadosIOTService.findById(id);
        return ResponseEntity.ok(dados);
    }

    @GetMapping("/checkin/{checkinId}")
    @Operation(summary = "Buscar dados por checkin", description = "Retorna dados de sensores vinculados a um checkin específico")
    public ResponseEntity<List<DadosIOTResponseDTO>> findByCheckinId(@PathVariable Long checkinId) {
        List<DadosIOTResponseDTO> dados = dadosIOTService.findByCheckinId(checkinId);
        return ResponseEntity.ok(dados);
    }

    @PostMapping
    @Operation(summary = "Criar dados IoT", description = "Registra novos dados de sensores IoT no sistema")
    public ResponseEntity<DadosIOTResponseDTO> create(@Valid @RequestBody DadosIOTRequestDTO dto) {
        DadosIOTResponseDTO dados = dadosIOTService.create(dto);
        return ResponseEntity.ok(dados);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar dados IoT", description = "Atualiza dados existentes de sensores")
    public ResponseEntity<DadosIOTResponseDTO> update(@PathVariable Long id, @Valid @RequestBody DadosIOTRequestDTO dto) {
        DadosIOTResponseDTO dados = dadosIOTService.update(id, dto);
        return ResponseEntity.ok(dados);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar dados IoT", description = "Remove dados de sensores do sistema")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        dadosIOTService.delete(id);
        return ResponseEntity.noContent().build();
    }
}