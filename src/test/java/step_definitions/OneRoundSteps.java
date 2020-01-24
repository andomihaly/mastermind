package step_definitions;
import io.cucumber.java.en.*;

import mastermind.CodePegs;
import mastermind.CodePegsColor;
import mastermind.Mastermind;
import org.junit.Assert;

public class OneRoundSteps {
    private CodePegs codePegs;
    private CodePegs masterPegs;
    @Given("^4 reds master pegs$")
    public void redsMasterPegs() {
        masterPegs = new CodePegs(CodePegsColor.Red,CodePegsColor.Red,CodePegsColor.Red,CodePegsColor.Red);
    }

    @When("^I guess 4 green pegs$")
    public void iGuess4GreenPegs() {
        codePegs = new CodePegs(CodePegsColor.Green,CodePegsColor.Green,CodePegsColor.Green,CodePegsColor.Green);
    }

    @Then("^No score$")
    public void noScore() {
        Mastermind m = new Mastermind();
        Assert.assertEquals("",m.evaulateGuess(masterPegs,codePegs));
    }
    @Given("^a red, green, blue and black master pins$")
    public void aRedGreenBlueAndBlackMasterPins() {
        masterPegs = new CodePegs(CodePegsColor.Red,CodePegsColor.Green,CodePegsColor.Blue,CodePegsColor.Black);
    }

    @When("^I guess with (.*?), (.*?), (.*?) and (.*?) pins$")
    public void iGuessWithPegs(String mypeg1, String mypeg2, String mypeg3,String mypeg4) {
        codePegs = new CodePegs();
        codePegs.peg1 = setCodePagsColor(mypeg1);
        codePegs.peg2 = setCodePagsColor(mypeg2);
        codePegs.peg3 = setCodePagsColor(mypeg3);
        codePegs.peg4 = setCodePagsColor(mypeg4);
    }

    @Then("^I get (.*?)$")
    public void iGetPegscore(String expectedScore) {
        Mastermind m = new Mastermind();
        Assert.assertEquals(expectedScore,m.evaulateGuess(masterPegs,codePegs));
    }

    private CodePegsColor setCodePagsColor(String mypeg1) {
        if (mypeg1.equals("green"))
            return CodePegsColor.Green;
        else if (mypeg1.equals("red"))
            return CodePegsColor.Red;
        else if (mypeg1.equals("black"))
            return CodePegsColor.Black;
        else if (mypeg1.equals("blue"))
            return CodePegsColor.Blue;
        else if (mypeg1.equals("brown"))
            return CodePegsColor.Brown;
        else if (mypeg1.equals("yellow"))
            return CodePegsColor.Yellow;
        else
            return null;
    }
}
