Feature: As a user I can create an account ssh

  Scenario: User can create an account ssh

    Given user is on main page
    And Select America server
    And Select Brazil server
    When user choose one server: 4
    Then user create an account with username: luis and pwd automatically
    And validate account: Account has been successfully created !
