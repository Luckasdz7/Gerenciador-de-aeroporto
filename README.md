# ✈️ Gerenciador de Aeroporto

Um sistema de gerenciamento de voos baseado em console, desenvolvido em Java. Este projeto aplica conceitos de Programação Orientada a Objetos (POO) e utiliza o padrão de projeto DAO (Data Access Object) junto com a camada BO (Business Object) para separar as regras de negócio do acesso ao banco de dados.

## 🚀 O que o programa faz e como funciona?

O sistema é executado diretamente no terminal e interage com um banco de dados MySQL para persistir as informações. Ao iniciar, o usuário tem acesso a um menu interativo onde pode gerenciar as rotas e os status dos aviões. 

As funcionalidades atuais incluem:
- **Salvar Voo:** Cadastra um novo voo no banco de dados informando o local de embarque, desembarque, número do voo (ex: GOL123), companhia aérea e o status atual.
- **Buscar por número:** Consulta e exibe as informações detalhadas de um voo específico através do seu número identificador.
- **Buscar todos os voos:** Retorna uma lista completa com todos os voos cadastrados no sistema.
- **Excluir voo:** Remove um registro do banco de dados utilizando o número do voo.

## 🛠️ Tecnologias Utilizadas

- **Java:** Lógica principal, orientação a objetos e interface no console via `Scanner`.
- **JDBC:** API para conexão e execução de comandos no banco de dados.
- **MySQL:** Banco de dados relacional para persistência dos voos.

## ⚙️ Como executar o projeto

1. Faça o clone deste repositório:
   ```bash
   git clone [https://github.com/luckasdz7/gerenciador-de-aeroporto.git](https://github.com/luckasdz7/gerenciador-de-aeroporto.git)
