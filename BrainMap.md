# GitHub User Activity CLI (Java)

## 🎯 Objetivo do Projeto
### Criar uma aplicação CLI
- Executar pelo terminal
- Receber username do GitHub
- Consumir API do GitHub
- Exibir atividades recentes

### Objetivos de aprendizado
- Trabalhar com APIs REST
- Fazer requisições HTTP em Java
- Manipular JSON
- Criar aplicações CLI
- Tratar erros
- Organizar projetos Java

---

## 🛠️ Tecnologias
### Java
- Linguagem principal

### HTTP Client
- HttpClient
- HttpRequest
- HttpResponse

### JSON
- org.json
- Gson
- Jackson

### Ferramentas
- IntelliJ IDEA
- VS Code
- Git
- GitHub

---

## 📂 Estrutura do Projeto
### Projeto
- github-user-activity
    - src
        - Main.java
        - service
            - GitHubService.java
        - model
            - GitHubEvent.java
        - util
            - EventFormatter.java
        - exception
            - ApiException.java
    - README.md
    - .gitignore

---

## 🚀 Fluxo da Aplicação

### 1. Usuário executa comando
- github-activity `<username>`

### 2. Capturar argumentos
- Verificar se username foi informado
- Mostrar mensagem de ajuda

### 3. Montar URL da API
- https://api.github.com/users/<username>/events

### 4. Fazer requisição HTTP
- Criar HttpClient
- Criar HttpRequest
- Enviar GET request

### 5. Receber resposta
- Status 200 → sucesso
- Status 404 → usuário não encontrado
- Outros → erro da API

### 6. Converter JSON
- Ler array JSON
- Extrair informações
    - type
    - repo.name
    - payload

### 7. Processar eventos
- PushEvent
- IssuesEvent
- WatchEvent
- ForkEvent
- CreateEvent

### 8. Mostrar no terminal
- Pushed commits
- Opened issue
- Starred repository
- Forked repository

---

## 🔥 Tipos de Eventos

### PushEvent
- Quantidade de commits
- Nome do repositório

### IssuesEvent
- Ação
    - opened
    - closed
- Nome do repositório

### WatchEvent
- Usuário deu estrela

### ForkEvent
- Usuário fez fork

### CreateEvent
- Criou branch
- Criou repositório

---

## 🧩 Classes da Aplicação

### Main.java
- Ler argumentos
- Iniciar aplicação
- Chamar serviços

### GitHubService.java
- Consumir API GitHub
- Fazer requisições HTTP
- Retornar dados

### GitHubEvent.java
- Representar evento GitHub
- Armazenar dados
    - type
    - repoName
    - action
    - commits

### EventFormatter.java
- Formatar mensagens amigáveis

### ApiException.java
- Tratar erros personalizados

---

## ⚠️ Tratamento de Erros

### Username vazio
- Mostrar usage correto

### Usuário inexistente
- Mostrar "User not found"

### Sem conexão
- Mostrar erro de conexão

### Limite da API
- Mostrar rate limit exceeded

### Erros inesperados
- Capturar exceções

---

## 📚 Conceitos Java

### Orientação a Objetos
- Classes
- Objetos
- Encapsulamento

### Collections
- List
- ArrayList

### HTTP
- GET Request
- Status Code

### JSON
- JSONArray
- JSONObject

### Exceções
- try/catch
- IOException
- InterruptedException

---

## 🧪 Testes

### Cenários principais
- Usuário válido
- Usuário inválido
- Sem argumentos
- Sem internet
- API indisponível

---

## ✨ Melhorias Futuras

### Filtros
- Filtrar por tipo de evento

### Interface terminal
- Cores
- Emojis
- Melhor formatação

### Performance
- Cache de respostas

### Configurações
- Limite de eventos
- Ordenação

### Novos endpoints
- Repositórios
- Seguidores
- Linguagens usadas

---

## 🏆 Objetivo no Portfólio

### Demonstrar habilidades
- Java
- APIs REST
- HTTP Requests
- JSON
- CLI
- Tratamento de erros
- Organização de projetos

### Projeto ideal para
- Roadmap.sh
- GitHub
- Portfólio backend
- Estudos de API