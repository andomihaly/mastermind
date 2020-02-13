Feature: MasterMind Championship

  Scenario: BestGamer
    Given a best gamer
    When she won all the 5 game
    Then the championship result is 5-0 score.

  Scenario: Equal Gamer
    Given two normal gamer
    When one gamer won 2 games
    And another gamer won 3 games
    Then the championship result is 2-3 score.