Feature: MasterMind One Round Evaluation
  Scenario: No match
    Given 4 reds master pins
    When I guess 4 green pins
    Then I get nothing

