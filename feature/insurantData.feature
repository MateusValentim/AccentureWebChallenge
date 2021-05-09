#language: pt

Funcionalidade: Preencher dados do seguro

  Contexto:
    Dado que estou na tela home
    Quando clico em automobile

  @PreenchimentoDadosSeguroFeliz
  Cenario: Preencher dados do seguro com sucesso
    E clico na aba Insurant Data
    E preencho os dados do seguro

      | firstName | lastName | birthDate  | streetAddress | country | zipCode  | city        | occupation   | webSite                           |
      | Mateus    | Valentim | 11/20/1996 | Rua Salvador  | Brazil  | 06325060 | Carapicuíba | Selfemployed | https://github.com/MateusValentim |

    E clico em Next