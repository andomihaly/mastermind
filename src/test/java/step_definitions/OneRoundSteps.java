package step_definitions;
import io.cucumber.java.en.*;

import mastermind.CodePegs;
import mastermind.CodePegsColor;
import mastermind.Mastermind;
import org.junit.Assert;

public class OneRoundSteps {
    private CodePegs codePegs;
    private CodePegs masterPegs;
    @Given("4 reds master pegs")
    public void redsMasterPegs() {
        masterPegs = new CodePegs(CodePegsColor.Red,CodePegsColor.Red,CodePegsColor.Red,CodePegsColor.Red);
    }

    @When("I guess 4 green pegs")
    public void iGuess4GreenPegs() {
        codePegs = new CodePegs(CodePegsColor.Green,CodePegsColor.Green,CodePegsColor.Green,CodePegsColor.Green);
    }
    @Then("I get nothing")
    public void iGetNothing() {
        Mastermind m = new Mastermind();
        Assert.assertEquals("",m.evaulateGuess(masterPegs,codePegs));
    }

}
