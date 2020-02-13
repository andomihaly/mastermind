package games;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Mas;
import mastermind.Mastermind;
import org.junit.Assert;

public class ChampionshipSteps {

    @Given("a best gamer")
    public void aBestGamer() {

    }

    @When("she won all the {int} game")
    public void sheWonAllTheGame(Integer numberOfWon) {

    }
    @Then("the championship result is {int}-{int} score.")
    public void theChampionshipResultIsScore(int scoreOneGamer, int scoreAnotherGamer) {
        Mastermind mastermind = new Mastermind();
        Assert.assertEquals(scoreOneGamer, mastermind.getChampionShip().AGamerScore);
        Assert.assertEquals(scoreAnotherGamer, mastermind.getChampionShip().BGamerScore);

    }
    @Given("two normal gamer")
    public void twoNormalGamer() {

    }

    @When("one gamer won {int} games")
    public void oneGamerWonGames(Integer int1) {

    }

    @When("another gamer won {int} games")
    public void anotherGamerWonGames(Integer int1) {

    }

}
