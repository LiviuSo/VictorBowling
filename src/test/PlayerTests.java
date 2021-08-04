package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import player.AutoPlayer;
import player.HumanPlayer;
import player.RandomGenerator;

public class PlayerTests {

    RandomGenerator randomGenerator = new RandomGenerator();

    @Test
    public void testHumanPlayerRoll() {
        HumanPlayer humanPlayer = new HumanPlayer("",randomGenerator);
        HumanPlayer.setDubug(true);
        int pins = humanPlayer.roll(10);
        HumanPlayer.setDubug(true);
        Assert.assertTrue(pins > 0);
        Assert.assertTrue(pins <= 10);
    }

    @Test
    public void testAutoPlayerRoll() {
        AutoPlayer autoPlayer = new AutoPlayer(randomGenerator);
        int pins = autoPlayer.roll(10);
        Assert.assertTrue(pins > 0);
        Assert.assertTrue(pins <= 10);
    }
}
