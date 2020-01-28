package step_definitions;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import mastermind.*;

public class OneRoundSteps {
    private CodePegs guessPegs;
    private CodePegs masterPegs;

    @ParameterType("[a-z ]+")
    public CodePegsColor pegcolor(String color) {
        return CodePegsColor.valueOf(capatalize(color));
    }

    public String capatalize(String text) {
        text = text.toLowerCase();
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    @Given("a {pegcolor}, {pegcolor}, {pegcolor} and {pegcolor} master pins")
    public void aMasterPegs(CodePegsColor masterpeg1, CodePegsColor masterpeg2, CodePegsColor masterpeg3, CodePegsColor masterpeg4) {
        masterPegs = new CodePegs();
        masterPegs.peg1 = masterpeg1;
        masterPegs.peg2 = masterpeg2;
        masterPegs.peg3 = masterpeg3;
        masterPegs.peg4 = masterpeg4;
    }

    @When("I guess with {pegcolor}, {pegcolor}, {pegcolor} and {pegcolor} pins")
    public void iGuessWithPegs(CodePegsColor guessPeg1, CodePegsColor guessPeg2, CodePegsColor guessPeg3, CodePegsColor guessPeg4) {
        guessPegs = new CodePegs();
        guessPegs.peg1 = guessPeg1;
        guessPegs.peg2 = guessPeg2;
        guessPegs.peg3 = guessPeg3;
        guessPegs.peg4 = guessPeg4;
    }

    @Then("^I get (.*?)$")
    public void iGetPegscore(String expectedScore) {
        assertPegGuess(expectedScore, masterPegs, guessPegs);
    }

    private void assertPegGuess(String expectedAnswer, CodePegs masterPegs, CodePegs codePegs) {
        Mastermind m = new Mastermind();
        Assert.assertEquals(generateAnswerPegsListFromString(expectedAnswer), m.evaulateGuess(masterPegs, guessPegs));
    }

    private List<AnswerPegsColor> generateAnswerPegsListFromString(String answerPegs) {
        if (isAnswerInputEmpty(answerPegs))
            return new ArrayList<AnswerPegsColor>();
        return ConvertAnswerPegStringToList(answerPegs);
    }

    private boolean isAnswerInputEmpty(String answerPegs) {
        return answerPegs == null || answerPegs.equals("");
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
}