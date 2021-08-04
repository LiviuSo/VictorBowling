package player;

public class PlayerFactory {

    private RandomGenerator randomGenerator;

    public PlayerFactory(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public Player getHumanPlayer(String name) {
        return new HumanPlayer(name, randomGenerator);
    }

    public Player getAutoPlayer() {
        return new AutoPlayer(randomGenerator);
    }

}
