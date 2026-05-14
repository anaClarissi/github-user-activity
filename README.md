---

# 🚀 GitHub User Activity CLI

[Desafio original (roadmap.sh)](https://roadmap.sh/projects/github-user-activity?utm_source=chatgpt.com)

Uma aplicação **CLI em Java** que consome a API do GitHub para exibir as atividades recentes de um usuário diretamente no terminal.

---

## 🔗 Repositório

👉 Project URL: https://github.com/anaClarissi/github-user-activity


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

---

## 🧠 Aprendizados

* Consumo de APIs REST
* HttpClient em Java 17+
* Manipulação de JSON com Gson
* Estrutura CLI
* Tratamento de exceções
* Arquitetura em camadas

---

## 🛠️ Tecnologias

* Java 17
* HttpClient
* Gson
* Maven
* Docker

---

## ⚙️ Como executar o projeto

### 🔧 Build

```bash
mvn clean package
```

### ▶️ Execução

```bash
java -jar target/github-user-activity-1.0-SNAPSHOT.jar <username>
```

Exemplo:

```bash
java -jar target/github-user-activity-1.0-SNAPSHOT.jar octocat
```

---

## 🐳 Docker

```bash
docker build -t github-activity-cli .
docker run github-activity-cli octocat
```

---

## 🧱 Estrutura

* Main → entrada da aplicação
* GitHubService → consumo da API
* GitHubEvent → modelo
* EventFormatter → formatação
* ApiException → erros

---

## 🏆 Objetivo no portfólio

Projeto ideal para demonstrar:

* APIs REST
* Java backend
* CLI tools
* Boas práticas de estruturação
* Dockerização

---