package br.com.fiap.Wellsess.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Wellsess API",
                version = "v1.0",
                description = "API para sistema de monitoramento de bem-estar emocional no ambiente corporativo - Projeto Acadêmico FIAP",
                contact = @Contact(
                        name = "Wellsess Team - FIAP",
                        email = "wellsess@fiap.com.br"
                )
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "Servidor Local")
        }
)
public class SwaggerConfig {
        // Configuração simples sem beans complexos
}