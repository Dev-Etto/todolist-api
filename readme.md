# ToDoList API

Bem-vindo ao **ToDoList API**, um gerenciador de tarefas simples e eficiente desenvolvido com Java e Spring Boot. Esse projeto foi criado para oferecer funcionalidades básicas de gerenciamento de tarefas, como criação, atualização, exclusão e filtragem de tarefas vinculadas a usuários.

## 🛠️ Tecnologias utilizadas

O projeto utiliza as seguintes tecnologias:

- **Java 17**: Linguagem principal de desenvolvimento.
- **Spring Boot 3.4.4**: Framework para simplificar o desenvolvimento do backend.
  - **Spring Boot Starter Web**: Para desenvolvimento da API REST.
  - **Spring Boot Starter Data JPA**: Para integração com o banco de dados utilizando JPA.
  - **Spring Boot DevTools**: Para suporte ao desenvolvimento, com reinicialização automática.
  - **Spring Boot Starter Test**: Para realizar os testes.
- **H2 Database**: Banco de dados em memória, ideal para desenvolvimento e testes.
- **Lombok**: Para reduzir o código padrão (boilerplate) em classes.
- **Jakarta Persistence API (JPA)**: Para mapeamento e manipulação dos modelos de dados.
- **BCrypt Library**: Para hash de senhas.

---

## 🔧 Como configurar e rodar o projeto localmente

Siga os passos abaixo para rodar a aplicação em sua máquina local:

### Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas:

- **Java 17** ou superior.
- **Maven** (construção e gerenciamento das dependências).
- **Git** (para clonar o repositório).

### Passos para rodar o projeto

1. **Clone o repositório:**
   ```bash
   git clone <URL-do-repositorio>
   cd todolist-api
   ```

2. **Compilar as dependências e construir o projeto:**
   ```bash
   mvn clean install
   ```

3. **Execute a aplicação:**
   - Com Maven:
     ```bash
     mvn spring-boot:run
     ```
   - Ou rodando o jar gerado:
     ```bash
     java -jar target/todolist-api-0.0.1-SNAPSHOT.jar
     ```

4. **Acesse a aplicação no navegador ou em um client como Postman:**
   - URL padrão: `http://localhost:8080`

---

## ⚙️ Principais Endpoints da API

Abaixo estão alguns dos endpoints disponíveis na API:

- **Obter todas as tarefas de um usuário:** `GET /tasks?userId={userId}`
- **Criar uma nova tarefa:** `POST /tasks`
- **Atualizar uma tarefa:** `PUT /tasks/{id}`
- **Deletar uma tarefa:** `DELETE /tasks/{id}`
- **Obter detalhes de um usuário:** `GET /users/{id}`
