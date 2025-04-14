Feature: Create a new client
  As a test automation
  I want to create a new client in Siigo
  So that finish the test

  @E2E
  Scenario: Successful Create Client
    Given the user test sing in siigo
    When go to menu crear cliente
    And fill basic data
      | tipo       | tipoIdentificacion   | identificacion | dv | codigoSucursal | nombres   | apellidos | nombreComercial | ciudad      | direccion | indicativo | numeroTelefono | extension |
      | Es persona | Cédula de ciudadanía | 1234567        | 7  | 32             | prueba qa | siggo     | automatizacion  | piedecuesta | calle     | 7          | 1234567890     | 57        |
    And fill billing and shipping information
      | nombresFacturacion | apellidosFacturacion | correo        | tipoRegimenIva        | indicativoFacturacion | telefonoFacturacion | codigoPostal | responsabilidadFiscal         |
      | prueba qa          | siggo                | test@mail.com | No responsable de IVA | 8                     | 1234567             | 90001        | Régimen simple de tributación |
    And fill contact information
      | nombre    | apellido | correoContact | cargo                 | indicativoContacto | telefonoContacto |
      | prueba qa | siggo    | test@mail.com | No responsable de IVA | 8                  | 1234567          |
    And fill observations
      | observaciones |
      | prueba qa     |
    Then create a new client an view message Tercero guardado exitosamente

  @E2E_Failed
  Scenario: Unsuccessful Create Client
    Given the user test sing in siigo
    When go to menu crear cliente
    And fill basic data
      | tipo       | tipoIdentificacion   | identificacion | dv | codigoSucursal | nombres   | apellidos | nombreComercial | ciudad      | direccion | indicativo | numeroTelefono | extension |
      | Es persona | Cédula de ciudadanía | 1234567        | 7  | 32             | prueba qa | siggo     | automatizacion  | piedecuesta | calle     | 7          | 1234567890     | 57        |
    And fill billing and shipping information
      | nombresFacturacion | apellidosFacturacion | correo    | tipoRegimenIva        | indicativoFacturacion | telefonoFacturacion | codigoPostal | responsabilidadFiscal         |
      | prueba qa          | siggo                | test@mail | No responsable de IVA | 8                     | 1234567             | 90001        | Régimen simple de tributación |
    And fill contact information
      | nombre    | apellido | correoContact | cargo                 | indicativoContacto | telefonoContacto |
      | prueba qa | siggo    | test@mail.com | No responsable de IVA | 8                  | 1234567          |
    And fill observations
      | observaciones |
      | prueba qa     |
    Then create a new client an view message Introduce un correo electrónico válido: ejemplo@email.com

  Scenario: Successful fill basic data
    Given the user test sing in siigo
    When go to menu crear cliente
    Then fill basic data
      | tipo       | tipoIdentificacion   | identificacion | dv | codigoSucursal | nombres   | apellidos | nombreComercial | ciudad      | direccion | indicativo | numeroTelefono | extension |
      | Es persona | Cédula de ciudadanía | 1234567        | 7  | 32             | prueba qa | siggo     | automatizacion  | piedecuesta | calle     | 7          | 1234567890     | 57        |

  Scenario: Successful fill billing and shipping information
    Given the user test sing in siigo
    When go to menu crear cliente
    Then fill billing and shipping information
      | nombresFacturacion | apellidosFacturacion | correo        | tipoRegimenIva        | indicativoFacturacion | telefonoFacturacion | codigoPostal | responsabilidadFiscal         |
      | prueba qa          | siggo                | test@mail.com | No responsable de IVA | 8                     | 1234567             | 90001        | Régimen simple de tributación |

  Scenario: Successful fill contact information
    Given the user test sing in siigo
    When go to menu crear cliente
    Then fill contact information
      | nombre    | apellido | correoContact | cargo                 | indicativoContacto | telefonoContacto |
      | prueba qa | siggo    | test@mail.com | No responsable de IVA | 8                  | 1234567          |

  Scenario: Successful fill seller and collector
    Given the user test sing in siigo
    When go to menu crear cliente
    Then fill seller and collector
      | vendedor  | cobrador |
      | prueba qa | siggo    |

  Scenario: Successful fill observations
    Given the user test sing in siigo
    When go to menu crear cliente
    Then fill observations
      | observaciones |
      | prueba qa     |
