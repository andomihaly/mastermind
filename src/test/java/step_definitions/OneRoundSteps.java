package step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;

import mastermind.*;

public class OneRoundSteps {
    private CodePegs guessPegs;
    private CodePegs masterPegs;

    @Given("^a (.*?), (.*?), (.*?) and (.*?) master pins$")
    public void aMasterPegs(String masterpeg1, String masterpeg2, String masterpeg3,String masterpeg4) {
        masterPegs = new CodePegs();
        masterPegs.peg1 = generateCodePegColor(masterpeg1);
        masterPegs.peg2 = generateCodePegColor(masterpeg2);
        masterPegs.peg3 = generateCodePegColor(masterpeg3);
        masterPegs.peg4 = generateCodePegColor(masterpeg4);
    }

    @When("^I guess with (.*?), (.*?), (.*?) and (.*?) pins$")
    public void iGuessWithPegs(String guessPeg1, String guessPeg2, String guessPeg3,String guessPeg4) {
        guessPegs = new CodePegs();
        guessPegs.peg1 = generateCodePegColor(guessPeg1);
        guessPegs.peg2 = generateCodePegColor(guessPeg2);
        guessPegs.peg3 = generateCodePegColor(guessPeg3);
        guessPegs.peg4 = generateCodePegColor(guessPeg4);
    }

    @Then("^I get (.*?)$")
    public void iGetPegscore(String expectedScore) {
        assertPegGuess(expectedScore,masterPegs,guessPegs);
    }

    private void assertPegGuess(String expectedAnswer, CodePegs masterPegs, CodePegs codePegs) {
        Mastermind m = new Mastermind();
        Assert.assertEquals(generateAnswerPegsListFromString(expectedAnswer), m.evaulateGuess(masterPegs, guessPegs));
    }

    private CodePegsColor generateCodePegColor(String mypeg1) {
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
            throw new InvalidCodePegsColor();
    }

    private List<AnswerPegsColor> generateAnswerPegsListFromString(String answerPegs){
        if (isAnswerInputEmpty(answerPegs))
            return new ArrayList<AnswerPegsColor>();
        return ConvertAnswerPegStringToList(answerPegs);
    }

    private boolean isAnswerInputEmpty(String answerPegs) {
        return answerPegs== null || answerPegs.equals("");
    }

    private List<AnswerPegsColor> ConvertAnswerPegStringToList(String answerPegs) {
        List<AnswerPegsColor> answerPegsColorList = new ArrayList<AnswerPegsColor>();
        String[] splitPegs = answerPegs.split(",");
        for (String peg : splitPegs) {
            answerPegsColorList.add(generateAnswerPegColor(peg));
        }
        return answerPegsColorList;
    }

    private AnswerPegsColor generateAnswerPegColor(String peg) {
        if (peg.equals("white"))
            return AnswerPegsColor.White;
        else if (peg.equals("black"))
            return AnswerPegsColor.Black;
        else
            throw new InvalidAnswerPegsColor();
    }

    private class InvalidAnswerPegsColor extends RuntimeException {
    }

    private class InvalidCodePegsColor extends RuntimeException {
    }
}