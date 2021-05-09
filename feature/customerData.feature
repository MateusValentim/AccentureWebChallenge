#language: pt

Funcionalidade: Preencher dados completos do cliente

  Contexto:
    Dado que estou na tela home
    Quando clico em automobile

  @PreencherDadosDoCliente
  Esquema do Cenario: Preencher os dados do cliente com sucesso
    E preencho os dados do "<customer>"
    E preencho os dados "<insurant>"
    E preencho os dados de "<product>"
    Quando seleciono a tabela de precos
    Entao preencho meus dados para "<sendQuote>"

    Exemplos:
      | customer | insurant | product    | sendQuote |
      | ehy2408  | Mateus   | 06/24/2021 | mvalentim |