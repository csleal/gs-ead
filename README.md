# gs-ead
Case para a prova semestral do 2TDS - 1° Semestre de 2022

**nome dos alunos:** 

* Carlos Rithyellen de Souza Leal - RM 89052
* Renan da Silva Ramos – RM 89339

**Turma:** 2TDSA

**Ano:** 2° ano, 2022

## Objetivo / descrição do Projeto

### Questões
1 - Crie um projeto maven com o nome gco-ead

2 – Configure o contexto de persistência no persistence.xml

3 – Adicione as dependências no pom.xml

4 – Crie as entidades de acordo com o MER definido acima

5 – Crie as classes DAO genéricas e as implementações, aplicando o
padrão de projeto singleton, com as operações básicas:
* salvar
* atualizar
* remover
* obterPorId
* listar

6 – Crie o GenericService e as implementações com as seguintes
operações:
* cadastrar
* atualizar
* remover
* obter
* listar

7 – Crie a classe com o método main

8 - Adicione ao projeto e configure o script para inserir no banco os dados
iniciais com o conteúdo do arquivo https://github.com/pcabrantes/fiap-eap/blob/master/scripts/jkcontrol.sql

9 – No método main, execute cada uma das operações abaixo, criando
novos métodos nos DAOs e Services, caso necessário:

9.1 – Cadastre um novo Condomínio

9.2 – Cadastre duas Portarias, uma com o nome “Principal” e outra com o
nome “Serviço”, associando a elas o condomínio criado no item 9.19.3 – Associada à portaria Principal, cadastre as movimentações com os
seguintes dados:
* Funcionário com id 1, Visitante com id 1, Tipo ‘E’, Data da
movimentação 2022-06-01 15:00:00
* Funcionário com id 1, Visitante com id 2, Tipo ‘E’, Data da
movimentação 2022-06-01 15:30:00
* Funcionário com id 2, Visitante com id 1, Tipo ‘S’, Data da
movimentação 2022-06-01 15:45:00

9.4 – Liste todas as movimentações com base no tipo da movimentação;

9.5 – Crie uma consulta que será montada dinamicamente para pesquisar
os visitantes cadastrados com base nos seguintes filtros:
CampoOperador
nomelike
cpfequal
data de cadastrogreaterThanOrEqualTo

## MER (Modelo Entidade Relacionamento)

<img src="/imagem.jpg" width="550">
