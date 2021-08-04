package player;

public class AutoPlayer extends Player {

    static int instanceCount = 0;

    public AutoPlayer(RandomGenerator randomGenerator) {
        super(randomGenerator);
        String name = "Player" + ++instanceCount;
        setName(name);
    }

    public static void resetInstanceCount() {
        instanceCount = 0;
    }

    @Override
    public int roll(int maxPinsToKnockDown) {
        return randomGenerator.getRandomInt(maxPinsToKnockDown);
    }

}