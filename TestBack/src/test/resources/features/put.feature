Feature: update user

  Scenario Outline: Update users info
    Given user connect to https://reqres.in
    When update user info from /api/users/ with <id>
      | <name> | <job> |
      | test   | qa    |
    Then validate 200

    Examples:
      | id | name   | job |
      | 2  | update | qa  |