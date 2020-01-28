Feature: MasterMind One Round Evaluation

  Scenario Outline: Compare master and guess pegs
    Given a red, green, blue and black master pins
    When I guess with <mypeg1>, <mypeg2>, <mypeg3> and <mypeg4> pins
    Then I get <pegscore>.
    Examples: There are hit during peg guess
      | mypeg1 | mypeg2 | mypeg3 | mypeg4 | pegscore    |
      | green  | red    | green  | green  | white,white |
      | red    | blue   | green  | green  | black,white |
      | black  | brown  | brown  | brown  | white       |
    Examples: MasterPegs are cover by our guess
      | mypeg1 | mypeg2 | mypeg3 | mypeg4 | pegscore                |
      | red    | green  | blue   | black  | black,black,black,black |
    Examples: There was no hit during actual guess
      | mypeg1 | mypeg2 | mypeg3 | mypeg4 | pegscore |
      | yellow | yellow | yellow | yellow | -        |