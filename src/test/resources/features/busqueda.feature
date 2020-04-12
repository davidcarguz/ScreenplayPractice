@Busquedas
  Feature: Casos de prueba de Busquedas en Ebay

    @busqueda
    Scenario: busqueda simple en ebay
      Given David ingresa a ebay
      When David busca por computadores
      And David filtra por Nuevo y América del Norte
      Then David valida los resultados