# Marketplace Backend (Spring Boot)

Este repositório contém o **backend** de um Marketplace, desenvolvido em Spring Boot. Ele fornece uma API REST para gerenciamento de usuários, categorias, produtos e pedidos.

## Funcionalidades

* CRUD de usuários (registro, consulta e exclusão)
* CRUD de categorias
* CRUD de produtos (associados a categorias)
* Gestão de pedidos (criação, listagem e exclusão)
* Listagem de pedidos por usuário

## Tecnologias

* **Java 17**
* **Spring Boot**
* **Spring Data JPA**
* **Banco de Dados**: H2 (desenvolvimento) / PostgreSQL (produção)
* **Build**: Maven

## Como Executar

1. Clone este repositório:

   ```bash
   git clone https://github.com/<SEU_USUARIO>/<SEU_REPOSITORIO>.git
   cd <PASTA_DO_PROJETO>
   ```
2. Execute o backend com H2 em memória (perfil `dev`):

    * Windows (PowerShell):

      ```powershell
      $Env:SPRING_PROFILES_ACTIVE="dev"; mvn spring-boot:run
      ```
    * Linux/macOS (Bash):

      ```bash
      SPRING_PROFILES_ACTIVE=dev mvn spring-boot:run
      ```
3. (Opcional) Acesse o console web do H2 em:

   ```
   http://localhost:8080/h2-console
   ```

    * JDBC URL: `jdbc:h2:mem:testdb`
    * Usuário: `sa`
    * Senha: *(sem senha)*

## Endpoints

(Base URL: `http://localhost:8080`)

### Categories

```http
GET    /categories
POST   /categories         { "name": "NomeDaCategoria" }
GET    /categories/{id}
PUT    /categories/{id}    { "name": "NomeAtualizado" }
DELETE /categories/{id}
```

### Products

```http
GET    /products
POST   /products           { "name": "...", "description": "...", "price": 0.0, "stock": 0, "categoryId": 1 }
GET    /products/{id}
PUT    /products/{id}      { "name": "...", "description": "...", "price": 0.0, "stock": 0 }
DELETE /products/{id}
```

### Users

```http
GET    /users
POST   /users              { "name": "Usuario", "email": "usuario@exemplo.com", "password": "senha", "role": "PAPEL" }
GET    /users/email/{email}
DELETE /users/{id}
```

### Orders

```http
POST   /orders/{userId}    [ { "product": { "id": 1 }, "quantity": 1 } ]
GET    /orders
GET    /orders/{id}
GET    /orders/user/{userId}
DELETE /orders/{id}
```

## Próximos Passos

* Implementar autenticação JWT
* Adicionar validações e tratamento de erros centralizado
* Escrever testes automatizados (unitários e de integração)
* Dockerizar a aplicação
