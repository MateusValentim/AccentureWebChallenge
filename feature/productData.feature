#language: pt

Funcionalidade: Preencher os dados do produto

  Contexto:
    Dado que estou na tela home
    Quando clico em automobile

  @PreencherDadosDoProdutoFeliz
    Cenario: Preencher os dados do produto com sucesso
    E clico na aba Product Data
    E preencho os dados do produto

      | startDate  | insuranceSum  | meritRating | damageInsurance | courtesyCar |
      | 06/24/2021 | 20.000.000,00 | Bonus 7     | Full Coverage   | Yes         |

    E clico no botao next