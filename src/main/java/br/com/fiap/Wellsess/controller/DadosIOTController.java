package br.com.fiap.Wellsess.controller;

import br.com.fiap.Wellsess.dto.DadosIOTRequestDTO;
import br.com.fiap.Wellsess.dto.DadosIOTResponseDTO;
import br.com.fiap.Wellsess.service.DadosIOTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dados-iot")
public class DadosIOTController {

    @Autowired
    private DadosIOTService dadosIOTService;

    @GetMapping
    public ResponseEntity<List<DadosIOTResponseDTO>> findAll() {
        List<DadosIOTResponseDTO> dados = dadosIOTService.findAll();
        return ResponseEntity.ok(dados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosIOTResponseDTO> findById(@PathVariable Long id) {
        DadosIOTResponseDTO dados = dadosIOTService.findById(id);
        return ResponseEntity.ok(dados);
    }

    @GetMapping("/checkin/{checkinId}")
    public ResponseEntity<List<DadosIOTResponseDTO>> findByCheckinId(@PathVariable Long checkinId) {
        List<DadosIOTResponseDTO> dados = dadosIOTService.findByCheckinId(checkinId);
        return ResponseEntity.ok(dados);
    }

    @PostMapping
    public ResponseEntity<DadosIOTResponseDTO> create(@RequestBody DadosIOTRequestDTO dto) {
        DadosIOTResponseDTO dados = dadosIOTService.create(dto);
        return ResponseEntity.ok(dados);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosIOTResponseDTO> update(@PathVariable Long id, @RequestBody DadosIOTRequestDTO dto) {
        DadosIOTResponseDTO dados = dadosIOTService.update(id, dto);
        return ResponseEntity.ok(dados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        dadosIOTService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
