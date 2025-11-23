package br.com.fiap.Wellsess.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @GetMapping("/api/health")
    public String apiHealth() {
        return "API OK";
    }
}
