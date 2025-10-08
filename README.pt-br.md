# KMProfessor

[🌐 English Version](README.md) 

Sistema de gerenciamento de provas utilizando **Java 17+ (Spring Boot)**, **Angular 17+** e **PostgreSQL**.

---

## 📚 Sobre o projeto

O objetivo do **KMProfessor** é permitir que professores cadastrem provas, questões e gabaritos, com integração ao ChatGPT para geração automática de respostas e funcionalidades futuras de importação/exportação.

---

## ⚙️ Tecnologias
- **Backend:** Java 17+ (Spring Boot)
- **Frontend:** Angular 17+
- **Banco de Dados:** PostgreSQL 16 (via Docker)
- **ORM:** Spring Data JPA / Hibernate
- **Autenticação:** JWT (JSON Web Token)

---

## 📌 Estrutura inicial

- Entidade `Professor` criada, contendo:
  - Nome
  - Email (com índice único no banco)
  - Senha (armazenada como hash)
  - API Key do OpenAI (armazenada criptografada)
  - Data de criação (`CreatedAt`)

- `Spring Data JPA Repository` implementado e configurado.

- `Flyway migration` inicial aplicada, criando a tabela `Professors` no banco `provas_db`.

---

## 📝 CHANGELOG

### [0.1.0] - 2025-08-19
- Configuração do ambiente Docker com PostgreSQL 16.
- Migração da stack de .NET para Java com Spring Boot.
- Criação da entidade `Professor` com JPA.
- Implementação do `ProfessorRepository` com Spring Data.
- Primeira migração criada com Flyway (tabela `professors`).
- Configuração da autenticação JWT com Spring Security.

---

## 🚀 Próximos passos

- Implementar autenticação via JWT:
  - Cadastro (`/auth/register`)
  - Login (`/auth/login`)
- Salvar e criptografar API Key do OpenAI.
- Criar endpoints para cadastro e gerenciamento de provas.
- Exportação de provas em PDF/Word.