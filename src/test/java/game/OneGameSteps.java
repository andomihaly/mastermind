package game;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import mastermind.CodePegs;
import mastermind.CodePegsColor;
import mastermind.Mastermind;
import mastermind.OneGameResult;

public class OneGameSteps {
    private CodePegs incorrectPegs = new CodePegs(CodePegsColor.Red, CodePegsColor.Red, CodePegsColor.Red, CodePegsColor.Red);
    private CodePegs correctPeg = new CodePegs(CodePegsColor.Red, CodePegsColor.Green, CodePegsColor.Blue, CodePegsColor.Black);
    //TODO: Here we can use knowObject to get the MasterPegs from OneRoundSteps file
    private CodePegs masterPegs = new CodePegs();
    private Mastermind mastermind = new Mastermind();

    @When("I guess with the correct pins")
    public void iGuessWithTheCorrectPins() {
        mastermind.evaulateGuess(masterPegs,incorrectPegs);
    }

    @When("^I guess with ([0-9]+) time with incorrect pins$")
    public void iGuessWithTimeWithIncorrectPins(int numberOfGuess) {
        for (int i = 0; i < numberOfGuess ; i++) {
            mastermind.evaulateGuess(masterPegs,incorrectPegs);
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
