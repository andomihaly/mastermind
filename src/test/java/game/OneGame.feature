Feature: MasterMind One Game

  @smoke
  Scenario: FastestGame
    Given a red, green, blue and black master pins
    When I guess with the correct pins
    Then I won the game.

  @quicktest
  Scenario: Normal Game
    Given a red, green, blue and black master pins
    When I guess with 5 time with incorrect pins
    And I guess with the correct pins
    Then I won the game.

  @smoke @quicktest
  Scenario: Failing Game
    Given a red, green, blue and black master pins
    When I guess with 10 time with incorrect pins
    Then I lose the game.