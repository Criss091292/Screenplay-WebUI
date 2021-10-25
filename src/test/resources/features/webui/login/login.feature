Feature: Hacer Login
  Como usuario de la aplicacion
  Necesito poder autenticarme mediante login en el aplicativo
  para poder acceder a la plataforma.

Background:
  Given el usuario esta en la pagina de login sin haberse autenticado

  Scenario: Login con datos correctos
    When diligencia los datos correctos
    Then deberia visualizar la pagina de usuarios del sistema

  Scenario: login con datos incorrectos
    When el usuario realiza la peticion
    Then deberia visualizar un mensaje de credenciales invalidas