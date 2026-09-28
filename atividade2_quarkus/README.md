<div align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/2/29/Quarkus_Logo.svg" alt="Quarkus Logo" width="200"/>
  <h1>🚗 UniCar - Sistema de Aluguel de Veículos</h1>
  <p><i>Projeto Acadêmico - Atividade 2 (Desenvolvimento com Frameworks Back-end Java)</i></p>
  
  <img src="https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Java"/>
  <img src="https://img.shields.io/badge/Quarkus-3.6-4794CB?style=for-the-badge&logo=quarkus&logoColor=white" alt="Quarkus"/>
  <img src="https://img.shields.io/badge/Maven-3.9-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven"/>
</div>

<br>

## 📌 Sobre o Projeto

Este projeto foi desenvolvido como requisito para a **Atividade 2** da disciplina de **Desenvolvimento com Frameworks Back-end Java** da Pós-Graduação (Unileya). 

O objetivo principal é demonstrar na prática a utilização de um dos frameworks Java estudados na **Unidade 2**. O framework escolhido foi o **Quarkus**, destacando-se por sua modernidade, tempo de startup ultrarrápido (*Supersonic Subatomic Java*) e foco em ambientes *Cloud Native*.

A aplicação consiste em uma **API RESTful** simples para o domínio de aluguel de carros (UniCar), permitindo visualizar a frota disponível e realizar locações.

---

## 🎯 Funcionalidades

- **`GET /carros/disponiveis`**: Retorna uma lista em formato JSON contendo apenas os veículos que não estão alugados.
- **`POST /carros/alugar/{placa}`**: Permite informar a placa de um veículo na URL para alterar seu status para indisponível (alugado).

---

## 🏗️ Estrutura da Arquitetura

O projeto adota uma arquitetura em camadas simplificada e utiliza Injeção de Dependências (CDI) nativa do Quarkus:

- 📦 **`Carro.java`**: Entidade de domínio (Modelo) que representa o veículo.
- ⚙️ **`CarroService.java`**: Classe de serviço (`@ApplicationScoped`) contendo a regra de negócio e simulando um banco de dados em memória.
- 🌐 **`CarroResource.java`**: Controlador REST (`@Path`, `@GET`, `@POST`) responsável por expor os endpoints HTTP.

---

## 🚀 Como Executar Localmente

### Pré-requisitos
- **Java JDK 17** ou superior.
- **Apache Maven** (Ou utilize sua IDE favorita como Eclipse/IntelliJ).

### Passos para Testar
1. Abra o terminal na pasta raiz do projeto (`atividade2_quarkus`).
2. Execute o comando para iniciar o servidor em modo de desenvolvimento (Live Coding):
   ```bash
   mvn compile quarkus:dev
   ```
3. A API estará rodando perfeitamente em `http://localhost:8080`.

### Exemplos de Requisição (cURL / PowerShell)

**Listar disponíveis:**
```powershell
Invoke-RestMethod -Uri http://localhost:8080/carros/disponiveis -Method GET
```

**Alugar veículo (ex: ABC-1234):**
```powershell
Invoke-RestMethod -Uri http://localhost:8080/carros/alugar/ABC-1234 -Method POST
```

---
<div align="center">
  <b>Desenvolvido por Márcio para fins avaliativos.</b>
</div>
