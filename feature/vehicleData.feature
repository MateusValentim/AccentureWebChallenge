#language: pt

Funcionalidade: Preencher dados do veículo

  Contexto:
    Dado que estou na tela home
    Quando clico em automobile

  @PreenchimentoFormularioFeliz
  Cenario: Preencher formulario do veículo com sucesso
    E clico na aba Vehicle Data
    E informo os dados do veículo

      | make       | enginePerformanceKw | inputDate  | numberOfSeats | fuelType | listPrice | licensePlateNumber | annualMileage |
      | Volkswagen | 14                  | 07/07/2020 | 5             | Petrol   | 57000     | ehy2408            | 2014          |

    Entao clico em next