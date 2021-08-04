package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import test.game.GameTestImpl;

public class GameTests {

    @Test
    public void testPlayBlueprint() {

        GameTestImpl gameTest = new GameTestImpl();
        gameTest.play();

        Assert.assertEquals(gameTest.setupGameMessage, "No of players: 2");
        Assert.assertEquals(gameTest.playGameMessage, "Playing...");
        Assert.assertEquals(gameTest.showWinnerMessage, "The winner is: John");
        Assert.assertEquals(gameTest.ensGameMessage, "Game over.");
    }

    // todo add tests

}
