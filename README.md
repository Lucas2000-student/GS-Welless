# 🏢 Wellsess - Sistema de Gestão de Bem-Estar Corporativo

<div align="center">

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2-green?style=for-the-badge&logo=springboot)
![Oracle](https://img.shields.io/badge/Oracle-Database-red?style=for-the-badge&logo=oracle)
![Swagger](https://img.shields.io/badge/Swagger-3.0-green?style=for-the-badge&logo=swagger)

**Solução para monitoramento do bem‑estar emocional no ambiente corporativo**

</div>

## 👥 Equipe

| RM | Nome | Função Principal |
|----|------|------------------|
| 560179 | Lucas da Ressurreição Barbosa | Java Backend & IoT Integration |
| 559210 | Ranaldo José da Silva | DevOps, QA & Mobile |
| 560694 | Fabrício José da Silva | Oracle Database & .NET |

## 🎯 Sobre o Projeto

Wellsess permite monitorar e melhorar o bem‑estar dos colaboradores com check‑ins de humor integrados a dados de sensores IoT.

### Diferenciais Técnicos
- Stored Procedures Oracle para inserts críticos
- Arquitetura em camadas (DTOs, Services)
- Validações com Bean Validation
- Paginação onde necessário
- Documentação com Swagger / OpenAPI
- Relacionamentos JPA otimizados

## 📊 Modelos e Diagramas

- Diagrama de Classes: docs/diagrama-classes.png
- Diagrama Entidade‑Relacionamento (DER): docs/diagrama-der.jpg

> Obs.: ajuste os nomes/caminhos das imagens se necessário.

## 🗂️ Estrutura do Projeto
```bash
src/
├── main/
│   ├── java/
│   │   └── br/com/fiap/Wellsess/
│   │       ├── config/          # Swagger, Security, CORS
│   │       ├── controller/      # REST Controllers
│   │       ├── dto/             # Request/Response DTOs
│   │       ├── entity/          # JPA Entities
│   │       ├── repository/      # JPA Repositories + Procedures
│   │       ├── service/         # Business Logic
│   └── resources/
│       ├── application.properties
│       └── db/
│           ├── scripts/         # SQL / procedures
│           └── seed/            # seed data (opcional)
```

## 🚀 Como Executar

### Pré-requisitos
- Java 17+
- Oracle Database (instância compatível)
- Gradle (wrapper incluído)
- (Opcional) Docker

### Execução Local (Windows - PowerShell)
```powershell
git clone <seu-repositorio>
cd Wellsess

# Variáveis de ambiente (PowerShell)
$env:DB_URL="jdbc:oracle:thin:@localhost:1521:XE"
$env:DB_USER="wellsess"
$env:DB_PASS="password"

# Build e execução
.\gradlew.bat clean bootRun
```

### Execução Local (Linux / macOS)
```bash
git clone <seu-repositorio>
cd Wellsess

export DB_URL="jdbc:oracle:thin:@localhost:1521:XE"
export DB_USER="wellsess"
export DB_PASS="password"

./gradlew clean bootRun
```

### Gerar JAR
```bash
./gradlew clean bootJar
java -jar build/libs/*.jar
```

## 🗄️ Oracle: scripts e procedures
- Scripts (procedures, tables, seed) em src/main/resources/db/scripts/ e src/main/resources/db/seed/
- Confirme criação de procedures no schema do DB_USER.
- Comandos úteis:
```sql
-- checar procedures
SELECT object_name, object_type FROM user_objects WHERE object_type = 'PROCEDURE';
```

## 📚 Documentação (Swagger / OpenAPI)
- Swagger UI (Springdoc default): http://localhost:8080/swagger-ui/index.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs

Se as URLs estiverem diferentes, confira br/com/fiap/Wellsess/config ou application.properties.

## 📡 Endpoints Principais (resumo)

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | /api/usuarios | Lista usuários (paginação) |
| POST | /api/usuarios | Cria usuário (procedure) |
| GET | /api/usuarios/{id} | Busca usuário por ID |
| PUT | /api/usuarios/{id} | Atualiza usuário |
| DELETE | /api/usuarios/{id} | Remove usuário |
| GET | /api/checkins | Lista checkins |
| POST | /api/checkins | Cria checkin (procedure) |
| GET | /api/checkins/usuario/{id} | Checkins por usuário |
| GET | /api/gestores | Lista gestores |
| POST | /api/gestores | Cria gestor (procedure) |
| GET | /api/setores | Lista setores |
| POST | /api/setores | Cria setor (procedure) |
| GET | /api/dados-iot | Lista dados IoT |
| POST | /api/dados-iot | Cria dado IoT (procedure) |

## 🧪 Testes
- Unitários: JUnit + Mockito
- Executar:
```bash
./gradlew test
```
Relatórios em build/reports (se configurado).

## 🛠️ Docker (opcional)
Exemplo mínimo de Dockerfile:
```dockerfile
FROM eclipse-temurin:17-jdk
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

Para banco Oracle em container, use imagem compatível e ajuste DB_URL/credenciais.

## 🔧 Troubleshooting Comum
- Conexão Oracle falha: verifique DB_URL, credenciais e listener.
- Procedures não encontradas: confirme schema e execução dos scripts.
- CORS: ajuste configuração em config/CorsConfig.
- Swagger não aparece: checar dependências do Springdoc e configurações.

## 📦 Artefatos Úteis no Repositório
- src/main/resources/db/scripts/ — procedures e DDL
- src/main/resources/db/seed/ — seed data (opcional)
- docs/ — diagramas, ER, Postman collection (docs/postman_collection.json)
- Dockerfile, .github/workflows/ (CI)


## 🤝 Contribuição
- Abra issues para bugs/feature requests.
- Branch naming: feature/<nome> ou fix/<id>.
- Escreva testes para novas features e inclua documentação.

## 📞 Contato
Consulte os responsáveis listados na seção "Equipe" para dúvidas técnicas.