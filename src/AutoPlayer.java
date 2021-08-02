public class AutoPlayer extends Player {

    static int instanceCount = 0;

    public AutoPlayer() {
        super();
        String name = "Player" + ++instanceCount;
        setName(name);
    }

    @Override
    public int roll(int maxPinsToKnockDown) {
        return randomGenerator.getRandomInt(maxPinsToKnockDown);
    }

}