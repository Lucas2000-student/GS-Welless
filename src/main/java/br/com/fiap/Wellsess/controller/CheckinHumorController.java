package br.com.fiap.Wellsess.controller;

import br.com.fiap.Wellsess.dto.CheckinHumorRequestDTO;
import br.com.fiap.Wellsess.dto.CheckinHumorResponseDTO;
import br.com.fiap.Wellsess.service.CheckinHumorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/checkins")
public class CheckinHumorController {

    @Autowired
    private CheckinHumorService checkinHumorService;

    @GetMapping
    public ResponseEntity<List<CheckinHumorResponseDTO>> findAll() {
        List<CheckinHumorResponseDTO> checkins = checkinHumorService.findAll();
        return ResponseEntity.ok(checkins);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CheckinHumorResponseDTO> findById(@PathVariable Long id) {
        CheckinHumorResponseDTO checkin = checkinHumorService.findById(id);
        return ResponseEntity.ok(checkin);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<CheckinHumorResponseDTO>> findByUsuarioId(@PathVariable Long usuarioId) {
        List<CheckinHumorResponseDTO> checkins = checkinHumorService.findByUsuarioId(usuarioId);
        return ResponseEntity.ok(checkins);
    }

    @PostMapping
    public ResponseEntity<CheckinHumorResponseDTO> create(@Valid @RequestBody CheckinHumorRequestDTO dto) {
        CheckinHumorResponseDTO checkin = checkinHumorService.create(dto);
        return ResponseEntity.ok(checkin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CheckinHumorResponseDTO> update(@PathVariable Long id, @Valid @RequestBody CheckinHumorRequestDTO dto) {
        CheckinHumorResponseDTO checkin = checkinHumorService.update(id, dto);
        return ResponseEntity.ok(checkin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        checkinHumorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}