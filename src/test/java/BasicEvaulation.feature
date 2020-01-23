Feature: MasterMind One Round Evaluation
  Scenario: No match between Pegs
    Given 4 reds master pegs
    When I guess 4 green pegs
    Then I get nothing

