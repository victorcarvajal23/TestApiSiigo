Feature: delete user

  Scenario Outline: delete user info
    Given user connect to https://reqres.in
    When delete user info from /api/users/ with <id>
    Then validate 204

    Examples:
      | id |
      | 2  |