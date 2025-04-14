Feature: create user

  Scenario: Create users info
    Given user connect to https://reqres.in
    When post user info from /api/users/ with
      | name | job |
      | test | qa  |
    Then validate 201
