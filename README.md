# Fintech app 
# autor: João Marcos Ribeiro Tolentino




---

## Como Rodar o Projeto

Siga os passos abaixo para rodar o projeto localmente:

### Pré-requisitos
- **Java 17** instalado.
- **Maven** instalado.
- **Docker** e **Docker Compose** instalados.

### Passos
1. **Clone o repositório** (se aplicável, ou apenas use a pasta `auth-service`):
   ```bash
   git clone <URL_DO_REPOSITORIO>
   cd auth-service

* Aplicação para uma carteira digital (fintech) com arquitetura de Microsserviços.*

---

## Badges

![Java](https://img.shields.io/badge/Java-17-orange)  
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.4-brightgreen)  
![Docker](https://img.shields.io/badge/Docker-Enabled-blue)  
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-lightblue)  
![JWT](https://img.shields.io/badge/JWT-Authentication-yellow)  


# Gerenciamento de Usuários:

Inicializa automaticamente um usuário padrão (admin/admin123) para testes.
Permite a persistência de usuários no banco de dados PostgreSQL.


# Contêinerização:
Configurado para rodar em contêineres Docker, com suporte a Docker Compose para orquestração do serviço e do banco de dados.

# Escalabilidade:
Arquitetura de microsserviço, pronta para integração com outros serviços (ex.: API Gateway, Eureka).


---


## Índice

- [Como Rodar o Projeto](#como-rodar-o-projeto)
- [Funcionalidades e Demonstração da Aplicação](#funcionalidades-e-demonstração-da-aplicação)
- [Acesso ao Projeto](#acesso-ao-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)


# Para testar o microsserviço:

auth-service:

mvn clean package (em auth-service)
docker-compose up --build  (em auth-service)
curl -X POST http://localhost:8080/auth/login -H "Content-Type: application/json" -d '{"username":"admin","password":"admin123"}'



transaction-service:

docker-compose up --build (em fintech-app na raiz)

Em transaction-service rodar:

Criar conta:
curl -X POST "http://localhost:8080/api/accounts?accountId=123&owner=João"

Consultar saldo:
curl -X GET "http://localhost:8080/api/accounts/123"

Fazer depósito:
curl -X POST "http://localhost:8080/api/accounts/123/deposit?amount=100.0"

Consultar saldo:
curl -X POST "http://localhost:8080/api/accounts/123/withdraw?amount=50.0"


