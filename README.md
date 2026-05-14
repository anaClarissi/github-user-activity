# 🚀 GitHub User Activity CLI

[Desafio original (roadmap.sh)](https://roadmap.sh/projects/github-user-activity?utm_source=chatgpt.com)

Uma aplicação **CLI em Java** que consome a API do GitHub para exibir as atividades recentes de um usuário diretamente no terminal.

---

## 🎯 Objetivo do Projeto

Criar uma ferramenta de linha de comando que:

* Recebe um username do GitHub
* Consulta a API pública do GitHub
* Retorna as atividades recentes do usuário
* Exibe os eventos de forma legível no terminal

---

## 📌 Demonstração

```bash
github-activity octocat
```

Saída esperada:

```
- Pushed commits to repo-name
- Starred repo-name
- Forked repo-name
```

---

## 🧠 Aprendizados

Este projeto reforça habilidades essenciais em backend Java:

* Consumo de APIs REST
* Uso de HttpClient em Java 17+
* Manipulação de JSON com Gson
* Estruturação de CLI
* Tratamento de exceções personalizadas
* Organização em camadas (service, model, util)

---

## 🛠️ Tecnologias

* Java 17
* HttpClient (Java standard)
* Gson
* Maven
* Docker

---

## 📁 Estrutura do Projeto

```
github-user-activity
├── src
│   ├── Main.java
│   ├── service
│   │   └── GitHubService.java
│   ├── model
│   │   └── GitHubEvent.java
│   ├── util
│   │   └── EventFormatter.java
│   └── exception
│       └── ApiException.java
├── target
├── Dockerfile
└── README.md
```

---

## ⚙️ Como executar o projeto

### 🔧 Pré-requisitos

* Java 17+
* Maven instalado
* Docker (opcional)

---

## ▶️ Execução local (sem Docker)

### 1. Clonar o projeto

```bash
git clone https://github.com/SEU_USUARIO/github-user-activity.git
cd github-user-activity
```

### 2. Build do projeto

```bash
mvn clean package
```

### 3. Executar o JAR

```bash
java -jar target/github-user-activity-1.0-SNAPSHOT.jar octocat
```

---

## 🐳 Execução com Docker

### 1. Build da imagem

```bash
docker build -t github-activity-cli .
```

### 2. Rodar o container

```bash
docker run github-activity-cli octocat
```

---

## ⚠️ Possíveis erros

| Situação               | Mensagem                            |
| ---------------------- | ----------------------------------- |
| Usuário não encontrado | User not found                      |
| API rate limit         | API rate limit exceeded             |
| Erro de conexão        | Error communicating with GitHub API |
| API fora do ar         | GitHub API is unavailable           |
| Sem argumento          | Usage: github-activity <username>   |

---

## 🧩 Funcionalidades

* Busca eventos públicos do usuário
* Formatação amigável no terminal
* Suporte a diferentes tipos de eventos:

    * PushEvent
    * WatchEvent
    * ForkEvent
    * IssuesEvent
    * CreateEvent

---

## 📦 Exemplos de uso

```bash
github-activity torvalds
github-activity octocat
github-activity nasa
```

---

## 🧱 Arquitetura

O projeto segue uma estrutura simples e organizada:

* **Main** → ponto de entrada da aplicação
* **GitHubService** → comunicação com API
* **GitHubEvent** → modelo de dados
* **EventFormatter** → formatação de saída
* **ApiException** → tratamento de erros

---

## 🚀 Melhorias futuras

* [ ] Paginação de eventos
* [ ] Filtros por tipo de evento
* [ ] Interface colorida no terminal
* [ ] Cache de requisições
* [ ] Suporte a múltiplos usuários

---

## 🏆 Objetivo de portfólio

Este projeto demonstra:

* Consumo de APIs reais
* Organização de código Java
* Boas práticas de CLI
* Tratamento de erros robusto
* Uso de Docker

---