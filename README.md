# Cadastro-Pessoas Back-End Rest API

Este é um projeto Rest API de cadastro de pessoas.

# Sobre o projeto

Basicamente, este projeto busca fornecer os serviços de *backend* de um CRUD de pessoas. Onde é possível listar as pessoas cadastradas, cadastrar uma nova pessoa, buscar por ID, atualizar e remover uma pessoa.

As principais funcionalidades que foram implementadas, são:

1. **API com rotas implementadas segundo o padrão REST**;
2. **Validações feitas conforme as regras de negócio**;
3. **Implementação de base de dados para persistência das informações**;
4. **Serviço de autenticação para acesso às rotas GET, POST, PUT e DELETE**.

# Ambiente de desenvolvimento:
- Linux Mint "Uma": o SO da máquina de desenvolvimento;
- Java: Linguagem de promação server-side;
- Framework Spring: Spring MVC e Spring Boot;
- Heroku: responsável por nossa infraestrutura na nuvem;
- MySQL: o MySQL é um banco de dados SQL gratuito.

Este projeto foi um experimento de desenvolvimento com um prazo curto. Simulando como seria na vida real de um desenvolvedor em uma empresa.

# Posso rodar este projeto local?

Se deseja clonar este projeto e executá-lo, certifique-se de ter um MySQL, ou outro banco SQL, disponível e adicionar as configurações no arquivo src/main/resources/application.properties

Se estiver usando o IntelliJ, não esqueça de fazer com que o Maven baixe as dependências do pom.xml

# Deploy

Como mencionado no começo do README, este projeto foi feito tendo em mente o *deploy* no Heroku.