package one_round;

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
    @ParameterType("[a-z, ]+")
    public CodePegs pegscolor(String pegsColor) {
        //parse: green, red, green and green;
        String [] colors = pegsColor.split(", ");
        if (colors.length == 3){
            return genetrateMasterPegsFromPegsColor(colors);
        }
        throw new InvalidPegsColorSetException();
    }

    private CodePegs genetrateMasterPegsFromPegsColor(String[] colors) {
        masterPegs = new CodePegs();
        masterPegs.peg1 = pegcolor(colors[0]);
        masterPegs.peg2 = pegcolor(colors[1]);
        //parse: green and green;
        colors = colors[2].split(" and ");
        if (colors.length == 2){
            masterPegs.peg3 = pegcolor(colors[0]);
            masterPegs.peg4 = pegcolor(colors[1]);
            return masterPegs;
        }
        throw new InvalidPegsColorSetException();
    }

    @ParameterType("[a-z,-]+")
    public List<AnswerPegsColor> answerColors(String answerPegs) {
        return generateAnswerPegsListFromString(answerPegs);
    }

    @Given("a {pegscolor} master pins")
    public void aMasterPegs(CodePegs actualMasterPeg) {
        masterPegs = actualMasterPeg;
    }

    @When("I guess with {pegcolor}, {pegcolor}, {pegcolor} and {pegcolor} pins")
    public void iGuessWithPegs(CodePegsColor guessPeg1, CodePegsColor guessPeg2, CodePegsColor guessPeg3, CodePegsColor guessPeg4) {
        guessPegs = new CodePegs();
        guessPegs.peg1 = guessPeg1;
        guessPegs.peg2 = guessPeg2;
        guessPegs.peg3 = guessPeg3;
        guessPegs.peg4 = guessPeg4;
    }

    @Then("I get {answerColors}.")
    public void iGetPegscore(List<AnswerPegsColor> expectedScore) {
        Mastermind m = new Mastermind();
        Assert.assertEquals(expectedScore, m.evaulateGuess(masterPegs, guessPegs));
    }

    public String capatalize(String text) {
        text = text.toLowerCase();
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    private List<AnswerPegsColor> generateAnswerPegsListFromString(String answerPegs) {
        if (isAnswerInputEmpty(answerPegs))
            return new ArrayList<AnswerPegsColor>();
        return ConvertAnswerPegStringToList(answerPegs);
    }

    private boolean isAnswerInputEmpty(String answerPegs) {
        return answerPegs == null || answerPegs.equals("") || answerPegs.equals("-");
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

    private class InvalidPegsColorSetException extends RuntimeException {
    }
}
