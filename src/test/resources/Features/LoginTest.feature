@LoginAmazonFeature
Feature: Probar inicio de sesion

  @SuccessLoginTest
  Scenario: Credenciales correctas
    Given usuario dentro del navegador web
    And usuario dentro de la pagina de amazon
    When usuario entre a inicio de sesion
    Then pagina de inicio desplegada
    When usuario ingrese correo
    And presione continuar
    Then pagina para contrasenia
    When usuario ingrese contrasenia
    And presione singin
    Then usuario entra a su sesion

	@UserNotValid
	Scenario: Usuario no valido
		Given usuario dentro del navegador web
    And usuario dentro de la pagina de amazon
    When usuario entre a inicio de sesion
    Then pagina de inicio desplegada
    When usuario ingrese correo inexistente
    And presione continuar
    Then pagina de usuario no existente desplegada