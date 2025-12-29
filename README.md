# Livraria Palavra Viva – Core

Projeto Java (Ant) contendo o núcleo de regras de negócio do sistema **Livraria Palavra Viva**,
refatorado a partir de um sistema desktop para preparação de migração para ambiente web.

## 🎯 Objetivo
Separar as responsabilidades do sistema, isolando:
- regras de negócio
- entidades do domínio
- persistência de dados

permitindo a reutilização do core em uma aplicação web.

## 🏗️ Estrutura do Projeto

- **model**  
  Contém as entidades do domínio (`Livro`, `Cliente`, `Venda`).

- **repository**  
  Define as interfaces de persistência.

- **repository.impl**  
  Implementações em memória dos repositórios.

- **service**  
  Camada de regras de negócio (validações, venda e controle de estoque).

- **exception**  
  Exceções de regras de negócio do sistema.

- **main**  
  Classe utilizada para testes manuais via console.

## 🧠 Princípios aplicados
- **SRP (Single Responsibility Principle)**  
- **DIP (Dependency Inversion Principle)**  

## 🧪 Testes
Os testes foram realizados manualmente através do método `main()`, simulando:
- cadastro de livros
- cadastro de clientes
- realização de vendas
- atualização automática de estoque

## 🔧 Tecnologias
- Java
- Apache NetBeans
- Git / GitHub
- Projeto Ant

## 📦 Observação
Este projeto representa apenas o **core do sistema**, sem interface gráfica ou web,
sendo preparado para integração futura com tecnologias web.
