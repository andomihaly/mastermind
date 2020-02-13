package game;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import known_object.KnownMasterMind;
import org.junit.Assert;

import mastermind.Mastermind;
import mastermind.OneGameResult;

public class OneGameSteps {
    private KnownMasterMind helper;
    private Mastermind mastermind = new Mastermind();

    public OneGameSteps() {
        helper = new KnownMasterMind();
    }

    @When("I guess with the correct pins")
    public void iGuessWithTheCorrectPins() {
        mastermind.evaulateGuess(helper.getMasterPeg(),helper.correctPegs);
    }

    @When("^I guess with ([0-9]+) time with incorrect pins$")
    public void iGuessWithTimeWithIncorrectPins(int numberOfGuess) {
        for (int i = 0; i < numberOfGuess ; i++) {
            mastermind.evaulateGuess(helper.getMasterPeg(),helper.incorrectPegs);
        }
    }

    @Then("I won the game.")
    public void iWonTheGame() {
        Assert.assertEquals(OneGameResult.WIN, mastermind.getGameResult());
    }

    @Then("I lose the game.")
    public void iLoseTheGame() {
        Assert.assertEquals(OneGameResult.LOSE, mastermind.getGameResult());
    }

}
