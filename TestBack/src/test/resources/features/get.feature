Feature: get user

  Scenario: get users info
    Given user connect to https://reqres.in
    When get users info from /api/users/
    Then validate 200


  Scenario Outline: get user info
    Given user connect to https://reqres.in
    When get user info from /api/users/ with <id>
    Then validate 200 and <id>

    Examples:
      | id |
      | 2  |