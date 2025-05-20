# KBoard - Quadro Kanban

API REST para gerenciamento de quadro Kanban desenvolvida em Kotlin com Spring Boot e MongoDB.

## 🚀 Tecnologias

- Kotlin
- Spring Boot 3.4.4
- MongoDB
- Maven

## 📋 Pré-requisitos

- JDK 21
- MongoDB
- Maven

## 🔧 Instalação

1. Clone o repositório:
```bash
git clone https://github.com/AlanPrzyvara/KBoard.git
```

2. Entre no diretório do projeto:
```bash
cd KBoard
```

3. Execute a aplicação:
```bash
./mvnw spring-boot:run
```

## 📦 Estrutura do Projeto

```
src/main/kotlin/com/api/kboard/
├── controller/     # Controladores REST
├── model/         # Entidades
├── repository/    # Repositórios MongoDB
├── service/       # Lógica de negócio
└── KboardApplication.kt
```

## 🔌 Endpoints

### Colunas

- `GET /api/columns` - Lista todas as colunas
- `POST /api/columns` - Cria uma nova coluna
- `GET /api/columns/{id}` - Busca uma coluna específica
- `PUT /api/columns/{id}` - Atualiza uma coluna
- `DELETE /api/columns/{id}` - Remove uma coluna

### Tarefas

- `GET /api/tasks` - Lista todas as tarefas
- `POST /api/tasks` - Cria uma nova tarefa
- `GET /api/tasks/{id}` - Busca uma tarefa específica
- `GET /api/tasks/column/{columnId}` - Lista tarefas de uma coluna
- `PUT /api/tasks/{id}` - Atualiza uma tarefa
- `PUT /api/tasks/{id}/move/{columnId}` - Move uma tarefa para outra coluna
- `DELETE /api/tasks/{id}` - Remove uma tarefa

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👨‍💻 Autor

Alan Przyvara - [GitHub](https://github.com/AlanPrzyvara) 