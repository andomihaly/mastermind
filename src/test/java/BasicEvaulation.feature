Feature: MasterMind One Round Evaluation
  Scenario Outline: Compare master and guess pegs
    Given a red, green, blue and black master pins
    When I guess with <mypeg1>, <mypeg2>, <mypeg3> and <mypeg4> pins
    Then I get <pegscore>
    Examples:
      | mypeg1 | mypeg2 | mypeg3 | mypeg4 | pegscore    |
      | green  | red    | green  | green  | white,white |
      | red    | blue   | green  | green  | black,white |
      | black  | brown  | brown  | brown  | white       |
    Examples:
      | mypeg1 | mypeg2 | mypeg3 | mypeg4 | pegscore |
      | yellow | yellow | yellow | yellow |          |