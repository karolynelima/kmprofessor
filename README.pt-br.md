# KMProfessor

[🌐 English Version](README.md) 

Sistema de gerenciamento de provas desenvolvido com **Java 17+ (Spring Boot)**, **Angular 17+** e **PostgreSQL**.

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

- Autenticação baseada em JWT com Spring Security:
  - `POST /auth/register`: Cadastrar um novo professor.
  - `POST /auth/login`: Autenticar e receber um JWT.

---

## ⚙️ Configuração

A configuração principal está no arquivo `src/main/resources/application.yml`. A aplicação utiliza variáveis de ambiente para dados sensíveis, com valores padrão para um ambiente de desenvolvimento.

Crie um arquivo `.env` na raiz do projeto ou defina as seguintes variáveis de ambiente:

````
# Senha do banco de dados (padrão é 'km')
DB_PASSWORD=sua_senha_postgres

# Chave secreta do JWT para assinatura do token (deve ser uma string longa e segura)
JWT_SECRET=uma-chave-secreta-longa-e-segura-com-pelo-menos-256-bits

# Chaves das APIs de Provedor de IA (opcional por enquanto)
OPENAI_API_KEY=sua_chave_da_api_do_openai
OPENROUTER_API_KEY=sua_chave_da_api_do_openrouter
DEEPSEEK_API_KEY=sua_chave_da_api_do_deepseek
````


---

## 🧪 Rodando a aplicação

1. Configure o Banco de Dados:

- Certifique-se de que você tenha uma instância do PostgreSQL rodando e que o banco de dados provas_db exista. Você pode usar o Docker para isso:

````
docker run --name kmprofessor-db -e POSTGRES_USER=km -e POSTGRES_PASSWORD=km -e POSTGRES_DB=provas_db -p 5432:5432 -d postgres:16
````

2. Build e Execução:
   
- Faça o build do projeto
````
mvn clean install
````
- Execute a aplicação
````
mvn spring-boot:run
````

3. Acesse a documentação da API (Swagger UI) em:
🔗 http://localhost:8080/swagger-ui/index.html.
- A aplicação estará disponível em http://localhost:8080.


---

## ✅ Migrations (Flyway)

- As migrações de banco de dados são gerenciadas pelo Flyway e são aplicadas automaticamente na inicialização.
- Para criar uma nova migração, adicione um novo arquivo SQL na pasta src/main/resources/db/migration/, seguindo o padrão V<VERSÃO>__<DESCRIÇÃO>.sql.
- As migrações de banco de dados são gerenciadas pelo Flyway. Elas estão na pasta src/main/resources/db/migration/.

Nota: No arquivo application.yml atual, o Flyway está desabilitado (flyway.enabled: false). Para que as migrações sejam executadas automaticamente na inicialização, altere essa propriedade para true.

## 🚀 Próximos passos

- Criptografar e salvar a chave da API OpenAI ao registrar o usuário.
- Criar endpoints para gerenciamento de provas e questões.
- Integrar com um serviço de IA (como OpenAI/OpenRouter) para geração automática de respostas.
- Implementar exportação de provas para formatos PDF/Word.