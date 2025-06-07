# 📚 Gerenciador de Biblioteca - Terceira Avaliação da Nota 1

**Disciplina:** Orientação a Objetos  
**Doscente:** Jonas Pontes  
**Discentes:** Giovanna Souza Correia - Vinícius Barros de Melo      

**Data de Entrega:** 06/06/2025  

Este projeto é parte da terceira avaliação da Nota 1 da disciplina de Orientação a Objetos, com o objetivo de aplicar os conceitos estudados em sala no desenvolvimento de uma aplicação Java orientada a objetos para o gerenciamento de uma biblioteca.

---

## 🎯 Objetivo

Desenvolver uma aplicação Java que implemente as seguintes práticas de programação orientada a objetos:

- Sintaxe básica da linguagem Java
- Modelagem orientada a objetos
- Abstração, classes, atributos e métodos
- Diagrama de classes (UML)
- Encapsulamento com métodos acessores e modificadores
- Construtores e sobrecarga
- Atributos e métodos estáticos
- Organização por pacotes
- Armazenamento simulado com `Map`
- Casos de uso implementados em classes de serviço

---

## ✨ Funcionalidades

### 📖 Gerenciamento de Livros

- Cadastrar livro (título, autor, ISBN, ano, editora e quantidade de exemplares)
- Consultar livro por ISBN
- Listar todos os livros
- Remover livro
- Buscar livros por autor

### 👤 Gerenciamento de Usuários (Leitores)

- Cadastrar usuário (nome, CPF, e-mail)
- Consultar usuário por CPF
- Listar todos os usuários
- Remover usuário

### 🔄 Empréstimos

- Realizar empréstimo de um livro para um usuário  
  - ❗ Não permitir empréstimo se o livro tiver apenas um exemplar disponível
- Registrar devolução de um livro
- Listar todos os livros emprestados
- Verificar livros disponíveis
- Manter histórico de empréstimos

---

## 📦 Estrutura de Pacotes

A estrutura do projeto está organizada da seguinte forma:

    biblioteca/
      ├── aplicacao/ -> Classe principal com interação por texto com o usuário (tem o método main);
      ├── modelo/ -> Classes como Livro, Usuario, Emprestimo;
      ├── repositorio/ -> Classes com Map simulando o banco de dados;
      ├── servico/ -> Casos de uso (CadastrarLivro, RealizarEmprestimo etc.).


---

## ⚙️ Regras Técnicas

- Uso adequado de **encapsulamento**
- Criação de **construtores** e uso de **sobrecarga**
- Aplicação de **atributos/métodos estáticos** sempre que necessário
- Elaboração e apresentação de um **diagrama UML**
- Separação clara das responsabilidades entre pacotes
