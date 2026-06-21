# ✈️ Gerenciador de Aeroporto

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)
![Status](https://img.shields.io/badge/Status-Concluído-success?style=for-the-badge)

Um sistema de gerenciamento de aeroporto e reservas de voos baseado em console. Desenvolvido em **Java** com conexão via **JDBC** a um banco de dados **MySQL**, este projeto aplica fortes conceitos de Programação Orientada a Objetos (POO), arquitetura em camadas e controle de acesso baseado em papéis (RBAC).

---

## 🚀 Funcionalidades e Controle de Acesso

O sistema possui um sistema de login robusto que divide as permissões de acordo com o perfil do usuário:

* **👑 Admin:** Acesso irrestrito. Pode realizar o CRUD (Criar, Ler, Atualizar, Excluir) de todas as entidades: Usuários, Voos, Aeronaves, Passageiros e Reservas.
* **👨‍💻 Operador:** Focado na gestão diária. Possui acesso CRUD para Passageiros e Reservas, além de poder consultar Voos e Aeronaves.
* **👤 Cliente:** Focado no autoatendimento. Pode gerenciar seu próprio cadastro de passageiro, buscar voos disponíveis e consultar suas próprias reservas.
* **👀 Viewer (Visitante):** Acesso rápido sem necessidade de login (apenas pressionando `ENTER`). Permite apenas leitura (buscar voos, checar passageiros e reservas).

---

## 🏗️ Arquitetura do Projeto

O código está estritamente dividido em camadas para facilitar a manutenção e escalabilidade:

### 1. Camada `model` (Modelos / POJOs)
Contém as classes que representam as entidades do banco de dados, com seus atributos, construtores, getters/setters e métodos `toString()` personalizados para a exibição no console.
* `aeronaves`, `passageiros`, `reservas`, `usuarios`, `voos`, e o Enum `perfil`.

### 2. Camada `DAO` (Data Access Object)
Responsável por toda a comunicação direta com o banco de dados via comandos SQL (`INSERT`, `UPDATE`, `DELETE`, `SELECT`).
* `aeronavesDAO`, `passageiroDAO`, `resevasDAO`, `usuarioDAO`, `voosDao`.

### 3. Camada `BO` (Business Object)
Aqui residem as **regras de negócio**. Nenhuma informação vai para o DAO sem antes ser validada pelo BO.
* Exemplos de validações: Impedir cadastro de aeronaves com capacidade irreal (> 853 passageiros), bloquear embarque e desembarque no mesmo local, validar CPFs nulos e gerenciar lógicas de autenticação.

### 4. Camada `menu` (Visão / UI)
A interface CLI (Command Line Interface) do sistema. O arquivo `menuaeroporto.java` gerencia a interação com o usuário utilizando a classe `Scanner`, invocando apenas os métodos da camada `BO`.

### 5. Camada `util`
* `Conexao.java`: Classe responsável por estabelecer e fornecer a conexão JDBC com o banco de dados MySQL utilizando um usuário dedicado (`app_aeroporto`).

---

## 🗄️ Banco de Dados Avançado

O projeto não utiliza apenas tabelas simples; ele implementa recursos avançados do MySQL:

* **Segurança:** Criação de um usuário específico de banco de dados (`app_aeroporto`) com permissões restritas (GRANT SELECT, INSERT, UPDATE, DELETE) para evitar o uso do `root` na aplicação.
* **Views (`vw_detalhes_reservas`):** Uma visualização consolidada que une as tabelas `reservas`, `passageiros` e `voos` usando `JOINs`, otimizando e limpando o código Java na hora da consulta.
* **Triggers de Auditoria (`trg_auditoria_exclusao_reserva`):** Um gatilho automático no banco que, toda vez que uma reserva é deletada, salva os dados da exclusão, a data e o usuário responsável em uma tabela de log (`log_reservas_excluidas`).

---

## ⚙️ Como executar o projeto

### Pré-requisitos
* Java Development Kit (JDK) 8 ou superior instalado.
* MySQL Server em execução na máquina local (porta padrão 3306).
* Uma IDE Java (recomendado: **Eclipse**).
* Driver JDBC do MySQL (`mysql-connector-j.jar`).

### Passo a passo

1. **Clone este repositório:**
   ```bash
   git clone [https://github.com/luckasdz7/gerenciador-de-aeroporto.git](https://github.com/luckasdz7/gerenciador-de-aeroporto.git)
